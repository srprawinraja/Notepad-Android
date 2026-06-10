package com.example.notepad.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.notepad.DetailScreenRoute
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteRepository
import com.example.notepad.ui.screen.ListScreen
import com.example.notepad.viewmodel.ListViewModel


@Composable
fun ShowNoteTitle(
    uId: Int, title: String, description: String, date: String?, onNext: (Int?) -> Unit
) {

    Row(modifier = Modifier
        .fillMaxWidth()
        .background(Color.White)
        .clickable(onClick = {
            onNext(uId)
        }), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(
            title.ifEmpty { description },
            modifier = Modifier
                .wrapContentSize(),
            color = Color("#808080".toColorInt()),
            fontSize = 25.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,

            )
        date?.let {
            Text(
                date,
                modifier = Modifier
                    .wrapContentSize(),
                color = Color("#808080".toColorInt()),
                fontSize = 25.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
    HorizontalDivider(
        modifier = Modifier
            .padding(1.dp)
            .width(5.dp)
    )
}


@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview
fun ShowNoteTitle() {
    ListScreen(
        listViewModel = ListViewModel(
            noteRepository = NoteRepository(
                context = LocalContext.current
            )
        ),
        paddingValues = PaddingValues.Zero
    ) {}
   // ShowNoteTitle(1, "note", "1", "11-11-2011", {})
}
