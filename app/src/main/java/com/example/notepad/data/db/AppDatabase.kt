package com.example.notepad.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteDto

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDto(): NoteDto
}