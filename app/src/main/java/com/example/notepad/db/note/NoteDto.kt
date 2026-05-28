package com.example.notepad.db.note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlin.uuid.Uuid

@Dao
interface NoteDto {
    @Query("SELECT * FROM note")
    suspend fun getAll(): List<Note>

    @Query("SELECT * FROM note WHERE uid = :uid")
    suspend fun getNote(uid: Int): Note

    @Insert
    suspend fun insertAll(vararg notes: Note)

}