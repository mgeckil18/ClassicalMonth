
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.classicalmonth.MusicCard
import com.example.classicalmonth.classicalMusicDatabase

@Composable
fun DetailScreen(navController: NavController) {
    var currentCardIndex by remember { mutableStateOf(0) }
    val notesMap = remember { mutableStateMapOf<Int, String>() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Details") })
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val currentMusicPiece = classicalMusicDatabase.getOrElse(currentCardIndex) { classicalMusicDatabase.first() }
            val currentNote = notesMap.getOrPut(currentCardIndex + 1) { "" }

            MusicCard(
                day = currentCardIndex + 1,
                musicTitle = currentMusicPiece.title,
                composer = currentMusicPiece.composer,
                description = "${currentMusicPiece.performer}, ${currentMusicPiece.duration}",
                note = currentNote,
                onNoteChange = { updatedNote -> notesMap[currentCardIndex + 1] = updatedNote }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Navigation buttons
            Row {
                Button(
                    onClick = {
                        if (currentCardIndex > 0) currentCardIndex--
                    },
                    enabled = currentCardIndex > 0
                ) {
                    Text("< Previous")
                }

                Spacer(modifier = Modifier.width(16.dp))

                Button(
                    onClick = {
                        if (currentCardIndex < classicalMusicDatabase.size - 1) currentCardIndex++
                    },
                    enabled = currentCardIndex < classicalMusicDatabase.size - 1
                ) {
                    Text("Next >")
                }
            }
        }
    }
}
