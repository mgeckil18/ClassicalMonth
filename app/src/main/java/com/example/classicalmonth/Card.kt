package com.example.classicalmonth


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun MusicCard(
    day: Int,
    musicTitle: String,
    composer: String,
    description: String,
    note: String,
    onNoteChange: (String) -> Unit
) {
    var isEditing by remember { mutableStateOf(false) }

    Card(
        elevation = 4.dp,
        modifier = Modifier.padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Displaying the card contents
            Image(
                painter = painterResource(id = R.drawable.image),
                contentDescription = "Music Image",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(350.dp)  // Set your desired height
            )
            Text(text = "Day $day", style = MaterialTheme.typography.h6)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = musicTitle, style = MaterialTheme.typography.subtitle1)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Composer: $composer", style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.body2)
            Spacer(modifier = Modifier.height(16.dp))

            // IconButton to toggle the edit mode
            IconButton(onClick = { isEditing = !isEditing }) {
                Icon(Icons.Default.Edit, contentDescription = "Edit Note")
            }

            // Note editing field
            if (isEditing) {
                TextField(
                    value = note,
                    onValueChange = onNoteChange,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.LightGray
                    )
                )
            } else {
                Text(text = note, modifier = Modifier.padding(8.dp))
            }
        }
    }
}
