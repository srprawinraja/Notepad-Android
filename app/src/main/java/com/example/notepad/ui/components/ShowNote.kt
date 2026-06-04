package com.example.notepad.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.notepad.DetailScreenRoute
import com.example.notepad.data.db.note.Note


@Composable
fun ShowNoteTitle(uId: Int, title: String, description: String, onNext: (Int?) -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color("#1D1D1F".toColorInt()))
            .clickable(onClick = {
                onNext(uId)
            }
            )
            .padding(10.dp)
    ) {
        Text(
            title.ifEmpty { description },
            modifier = Modifier
                .padding(start = 10.dp)
                .wrapContentSize(),
            color = Color.White,
            fontSize = 25.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
    Spacer(modifier = Modifier
        .padding(1.dp)
        .width(5.dp))
}
