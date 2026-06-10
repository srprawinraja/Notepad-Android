package com.example.notepad.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notepad.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    uid: Int?,
    paddingValues: PaddingValues
) {
    LaunchedEffect(Unit) {
        uid?.let {  detailViewModel.showNote(uid)}
    }

    DisposableEffect(Unit) {
        onDispose {
            detailViewModel.save(uid, detailViewModel.title.value, detailViewModel.description.value)
        }
    }
    Column (
        modifier = Modifier.fillMaxSize().background(Color.White
        ).fillMaxSize().padding(paddingValues)
    ){
        TextField(
            value = detailViewModel.title.value,
            onValueChange = { detailViewModel.title.value = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            placeholder = {
                Text("enter a title")
            },

        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        TextField(
            value = detailViewModel.description.value,
            onValueChange = { it ->  detailViewModel.description.value = it },
            modifier = Modifier.fillMaxSize(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.Black
            ),
            placeholder = {
                Text("enter a description")
            }
        )
    }
}