package com.example.notepad.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.db.note.Note
import com.example.notepad.db.note.NoteDto

@Database(entities = [Note::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDto(): NoteDto
}