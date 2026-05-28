package com.example.notepad.viewmodel

import android.app.Application
import android.content.Context
import com.example.notepad.db.AppDatabaseInstance
import com.example.notepad.db.note.Note

class DetailViewModel(
    val context: Context
) {
    fun save(title: String, description: String){
        AppDatabaseInstance.getInstance(context).noteDto().insertAll(Note(title= title, description = description))
    }
}