package com.example.notepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.example.notepad.data.db.note.NoteRepository
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
                Scaffold { paddingValues ->
                    App(listViewModel, detailViewModel, paddingValues)
                }
            }
        }
    }
}



@Composable
fun App(
    listViewModel: ListViewModel,
    detailViewModel: DetailViewModel,
    paddingValues: PaddingValues
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ListScreenRoute) {
        composable<ListScreenRoute> { ListScreen(listViewModel,  paddingValues){ uId ->
            navController.navigate(DetailScreenRoute(null))
        } }
        composable<DetailScreenRoute> {
                backStackEntry ->
            val detailScreen: DetailScreenRoute = backStackEntry.toRoute()
            DetailScreen(detailViewModel, detailScreen.uid, paddingValues)
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


