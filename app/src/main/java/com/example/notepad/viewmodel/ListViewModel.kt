package com.example.notepad.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepad.db.AppDatabaseInstance
import com.example.notepad.db.note.Note
import com.example.notepad.db.note.NoteDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    context: Context
): ViewModel() {
    private val _uiState = MutableStateFlow()
    val uiState: StateFlow<
            <Note>> = _uiState.asStateFlow()

    suspend fun getAllNotes(){
        viewModelScope.launch {
            
        }
    }
}