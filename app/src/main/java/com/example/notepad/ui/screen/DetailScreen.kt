package com.example.notepad.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.notepad.viewmodel.DetailViewModel

@Composable
fun DetailScreen(
    detailViewModel: DetailViewModel,
    uid: Int
) {

    val title = remember {
        mutableStateOf("Untitled")
    }

    val description = remember {
        mutableStateOf("")
    }

    DisposableEffect(Unit) {
        onDispose {
            detailViewModel.save(title.value, description.value)
        }
    }
    Column (
        modifier = Modifier.fillMaxSize().background(Color.Black).fillMaxSize()
    ){
        TextField(
            value = title.value,
            onValueChange = { it -> title.value = it },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )
        Spacer(modifier = Modifier.padding(top = 20.dp))
        TextField(
            value = description.value,
            onValueChange = { it -> description.value = it },
            modifier = Modifier.fillMaxSize(),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Black,
                unfocusedContainerColor = Color.Black,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )
    }
}