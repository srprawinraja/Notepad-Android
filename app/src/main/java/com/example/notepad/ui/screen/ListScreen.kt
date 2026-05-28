package com.example.notepad.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.notepad.DetailScreenRoute
import com.example.notepad.R
import com.example.notepad.ui.components.ShowNoteTitle
import com.example.notepad.viewmodel.ListViewModel

//data class Note(
//    val id: Int,
//    val title: String,
//    val description: String
//)
//val notes = listOf<Note>(
//    Note(1,"untitiled", "descritpion"),
//    Note(2, "new", "new")
//)


@Composable
fun ListScreen(listViewModel: ListViewModel, navController: NavHostController) {
    val uiState = listViewModel.uiState.collectAsState()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "List",
                color = Color.White
            )

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(uiState.value) { note ->
                    ShowNoteTitle(note, navController)
                }
            }
        }

        FloatingActionButton(
            onClick = {
                navController.navigate(DetailScreenRoute(-1))
            },
            modifier = Modifier
                .align(Alignment.BottomCenter).padding(bottom = 50.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.outline_add_circle_24),
                contentDescription = "add icon"
            )
        }
    }
}