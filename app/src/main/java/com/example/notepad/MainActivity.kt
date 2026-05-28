package com.example.notepad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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


