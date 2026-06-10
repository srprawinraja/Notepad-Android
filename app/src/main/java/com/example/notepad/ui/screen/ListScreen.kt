package com.example.notepad.ui.screen

import android.annotation.SuppressLint
import android.graphics.fonts.Font
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.navigation.NavHostController
import com.example.notepad.DetailScreenRoute
import com.example.notepad.R
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteRepository
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
fun ListScreen(
    listViewModel: ListViewModel,
    paddingValues: PaddingValues,
    onNextScreen: (Int?) -> Unit,
) {
    val uiState = listViewModel.uiState.collectAsState(
        initial = emptyList()
    )


    Column(
        modifier = Modifier.fillMaxSize().background(Color.White).padding(paddingValues).padding(30.dp)
    ) {

        Spacer(modifier = Modifier.padding(30.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = Color.White).padding(top = 20.dp, bottom=100.dp, start = 10.dp, end = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("ZEN\nNOTE", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            IconButton(
                onClick = {

                }) {
                Icon(imageVector = Icons.Default.Search, contentDescription = "", tint = Color("#808080".toColorInt()), modifier = Modifier.size(50.dp))
            }
        }
        Spacer(modifier = Modifier.padding(20.dp))
        Text("Your Notes", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.padding(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Title", color = Color.Black, fontSize = 15.sp, fontWeight = FontWeight.Bold)
            Text("Date", color = Color.Black,  fontSize = 15.sp, fontWeight = FontWeight.Bold)
        }
        Spacer(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).height(1.dp).background(Color.Black))

        LazyColumn(
            modifier = Modifier
                .wrapContentSize()
                .clip(RoundedCornerShape(16.dp))
                .border(
                    width = 2.dp,
                    color = Color.Unspecified,
                    shape = RoundedCornerShape(16.dp)
                )
        ) {
            if (uiState.value.isEmpty()) {
                item {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.wrapContentSize(),
                            painter = painterResource(R.drawable.no_found),
                            contentDescription = ""
                        )
                    }
                }
            } else {
                items(uiState.value) { note ->
                    ShowNoteTitle(note.uid, note.title, note.description, note.createdAt, onNext = onNextScreen)
                }
            }
        }
    }


}


@SuppressLint("ViewModelConstructorInComposable")
@Composable
@Preview
fun ListScreenPreview() {
    ListScreen(
        listViewModel = ListViewModel(
            noteRepository = NoteRepository(
                context = LocalContext.current
            )
        ),
        paddingValues = PaddingValues.Zero
    ) {}
}

