package com.parach.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.tooling.preview.Preview
import com.parach.noteapp.data.NotesDataSource
import com.parach.noteapp.models.Note
import com.parach.noteapp.screens.NoteScreen
import com.parach.noteapp.ui.theme.NoteAppTheme

class MainActivity : ComponentActivity() {
    @ExperimentalComposeUiApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    val notes = remember{
                        mutableStateListOf<Note>()
                    }
                    NoteScreen(notes = notes,
                        onAddNote = {
                         notes.add(it)
                    },
                        onRemoveNote = {
                            notes.remove(it)
                        })
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NoteAppTheme {

    }
}