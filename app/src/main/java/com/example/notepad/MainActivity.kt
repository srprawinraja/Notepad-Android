package com.example.notepad

import android.annotation.SuppressLint
import android.graphics.fonts.Font
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.toColorInt
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteRepository
import com.example.notepad.ui.components.ShowNoteTitle
import com.example.notepad.ui.screen.DetailScreen
import com.example.notepad.ui.screen.ListScreen
import com.example.notepad.ui.theme.NotepadTheme
import com.example.notepad.viewmodel.DetailViewModel
import com.example.notepad.viewmodel.ListViewModel
import kotlinx.serialization.Serializable

@Serializable
object ListScreenRoute
@Serializable
data class DetailScreenRoute(val uid: Int?)
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val noteRepository = NoteRepository(this)
        val listViewModel = ListViewModel(noteRepository)
        val detailViewModel = DetailViewModel(noteRepository)

        setContent {
            NotepadTheme {
                App(listViewModel, detailViewModel)
            }
        }
    }
}



@Composable
fun App(
    listViewModel: ListViewModel,
    detailViewModel: DetailViewModel
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> { ListScreen(listViewModel, navController) }
        composable<DetailScreenRoute> {
                backStackEntry ->
            val detailScreen: DetailScreenRoute = backStackEntry.toRoute()
            DetailScreen(detailViewModel, detailScreen.uid)
        }
    }
}
//
//
//
//val notes = listOf<Note>(
//    Note(1,"untitiled", "descritpion"),
//    Note(2, "new", "new")
//)
//
//@SuppressLint("ViewModelConstructorInComposable")
//@Preview(showBackground = true)
//@Composable
//fun ListScreenPreview(){
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Black).statusBarsPadding()
//
//    ) {
//
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            Text(
//                text = "List",
//                color = Color.White,
//                fontSize = 20.sp
//            )
//
//            Spacer(modifier = Modifier.height(20.dp))
//
//            LazyColumn(
//                modifier = Modifier.wrapContentSize().padding(20.dp)
//                    .clip(RoundedCornerShape(16.dp))
//                    .border(
//                        width = 2.dp,
//                        color = Color.Unspecified,
//                        shape = RoundedCornerShape(16.dp)
//                    )
//            ) {
//                items(notes) { note ->
//                    ShowNoteTitle(note, NavHostController(LocalContext.current))
//                }
//            }
//        }
//
//        FloatingActionButton(
//            onClick = {
//            },
//            modifier = Modifier
//                .align(Alignment.BottomCenter).padding(bottom = 50.dp)
//        ) {
//            Image(
//                painter = painterResource(R.drawable.outline_add_circle_24),
//                contentDescription = "add icon"
//            )
//        }
//    }
//}


