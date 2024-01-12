package com.example.classicalmonth

import DetailScreen
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import java.time.LocalDate


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "mainScreen") {
                    composable("mainScreen") { MainScreen(navController) }
                    composable("listScreen") { ListScreen() }
                    composable("detailScreen") { DetailScreen(navController) }
                }
            }
        }
    }
}



@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MainScreen(navController: NavController) {
    val today = LocalDate.now().dayOfMonth
    val todayMusicPiece = classicalMusicDatabase.getOrNull(today - 1) ?: classicalMusicDatabase.first()
    val todayNote = remember { mutableStateOf("") }
    val buttonShape: Shape = RoundedCornerShape(50) // Circular shape

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MusicCard(
            day = today,
            musicTitle = todayMusicPiece.title,
            composer = todayMusicPiece.composer,
            description = "${todayMusicPiece.performer}, ${todayMusicPiece.duration}",
            note = todayNote.value,
            onNoteChange = { updatedNote -> todayNote.value = updatedNote }
        )

        Spacer(modifier = Modifier.height(24.dp)) // Space between the card and the buttons

        // Button to view all pieces
        Button(
            onClick = { navController.navigate("listScreen") },
            shape = buttonShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 50.dp), // Set the desired padding here
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {
            Text(
                "View All",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }

        Spacer(modifier = Modifier.height(16.dp)) // Space between buttons

        // Button to view details of the current piece
        Button(
            onClick = { navController.navigate("detailScreen") },
            shape = buttonShape,
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp)
                .padding(horizontal = 50.dp), // Set the desired padding here
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
        ) {
            Text(
                "View Detail",
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        }
    }
}






val PrimaryColor = Color(0xFF4A6572) // A deep blue-gray
val SecondaryColor = Color(0xFF344955) // A darker shade for contrast
val TertiaryColor = Color(0xFFF9AA33) // A vibrant accent color


val LightColorPalette = lightColors(
    primary = PrimaryColor,
    primaryVariant = SecondaryColor,
    secondary = TertiaryColor,
)

val AppTypography = Typography(
    defaultFontFamily = FontFamily.Serif,
    h1 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    )
    // Add other text styles as needed
)



@Composable
fun AppTheme(content: @Composable () -> Unit) {
    val colors = lightColors(
        primary = PrimaryColor,
        secondary = SecondaryColor
        // Define other color properties if needed
    )

    MaterialTheme(
        colors = colors,
        typography = AppTypography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}


