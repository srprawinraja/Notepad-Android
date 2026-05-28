package com.example.notepad.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notepad.data.NetworkResponse
import com.example.notepad.data.db.AppDatabaseInstance
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ListViewModel(
    val noteRepository: NoteRepository
): ViewModel() {
    val uiState = noteRepository.getAllNotes()
}