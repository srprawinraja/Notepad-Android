package com.example.notepad.data.db

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notepad.data.db.note.Note
import com.example.notepad.data.db.note.NoteDto

@Database(entities = [Note::class], version = 2, autoMigrations = [
    AutoMigration(from = 1, to = 2)
], exportSchema = true)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDto(): NoteDto
}