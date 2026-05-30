package com.example.notepad.viewmodel

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepad.data.db.AppDatabaseInstance
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteRepository
import kotlinx.coroutines.launch

class DetailViewModel(
    val noteRepository: NoteRepository
): ViewModel(){
    val title = mutableStateOf("")

    val description = mutableStateOf("")

    fun save(uId: Int?, newTitle: String, newDescription: String){
        viewModelScope.launch {
           if(uId == null){
               if(newTitle.isNotEmpty() || newDescription.isNotEmpty())
                noteRepository.insertNote(Note(title = newTitle, description = newDescription))
           } else {
               noteRepository.getNote(uId)?.copy(title = newTitle, description = newDescription)?.let { it->
                   noteRepository.updateNote(it)
               }
           }
            discard()
        }
    }
    fun discard(){
        title.value = ""
        description.value = ""
    }
    fun showNote(uId: Int){
        viewModelScope.launch {
            noteRepository.getNote(uId)?.let{
                it->
                title.value = it.title
                description.value = it.description
            }
        }
    }
}