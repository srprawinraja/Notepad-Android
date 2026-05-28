package com.example.notepad.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.notepad.DetailScreenRoute
import com.example.notepad.data.db.note.Note


@Composable
fun ShowNoteTitle(note: Note, navController: NavHostController){
    Row(
        modifier = Modifier.fillMaxWidth().background(Color("#1D1D1F".toColorInt())).
        clickable(onClick = {
                    navController.navigate(DetailScreenRoute(note.uid))
                }
            )
        ){
        Text(note.title, modifier = Modifier.padding(start = 10.dp), color = Color.White)
    }
    Spacer(modifier = Modifier.fillMaxWidth().background(Color.White))
}