package com.example.notepad.data.db.note

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDto {
    @Query("SELECT * FROM note")
    fun getAll(): Flow<List<Note>>

    @Query("SELECT * FROM note WHERE uid = :uid")
    suspend fun getNote(uid: Int): Note?

    @Insert
    suspend fun insertAll(vararg notes: Note)

    @Update
    suspend fun updateNote(notes: Note)

}