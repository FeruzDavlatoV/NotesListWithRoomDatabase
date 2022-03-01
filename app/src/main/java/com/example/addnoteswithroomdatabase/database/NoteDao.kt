package com.example.addnoteswithroomdatabase.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.addnoteswithroomdatabase.model.Note


@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNote(note: Note):Long

    @Query("SELECT * FROM note")
    fun getNotes(): List<Note>


}