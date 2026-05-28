package com.example.notepad.data.db.note

import android.content.Context
import com.example.notepad.data.db.AppDatabaseInstance
import kotlinx.coroutines.flow.Flow

class NoteRepository(
    val context: Context
) {
    val noteDto = AppDatabaseInstance.getInstance(context).noteDto()
    suspend fun insertNote(note: Note){
        noteDto.insertAll(note)
    }
    suspend fun updateNote(note: Note){
        noteDto.updateNote(note)
    }
    suspend fun getNote(uId: Int) = noteDto.getNote(uId)
    fun getAllNotes() = noteDto.getAll()
}