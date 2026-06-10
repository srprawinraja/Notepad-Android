package com.example.notepad.data.db.note

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
@Entity
data class Note(
    @PrimaryKey(autoGenerate = true)  val uid: Int = 0,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "created_at") val createdAt: String? = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
)