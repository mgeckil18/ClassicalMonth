package com.example.classicalmonth

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember


@Composable
fun ListScreen() {
    val cardData = List(31) { "Card ${it + 1}" }
    val notesMap = remember { mutableStateMapOf<Int, String>() }

    LazyColumn {
        items(classicalMusicDatabase) { musicPiece ->
            val note = notesMap.getOrPut(musicPiece.id) { "" }

            MusicCard(
                day = musicPiece.id,
                musicTitle = musicPiece.title,
                composer = musicPiece.composer,
                description = "${musicPiece.performer}, ${musicPiece.duration}",

                note = note,
                onNoteChange = { updatedNote -> notesMap[musicPiece.id+1] = updatedNote }
            )
        }

    }
}

