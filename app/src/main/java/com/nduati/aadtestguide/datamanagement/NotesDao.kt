package com.nduati.aadtestguide.datamanagement

import androidx.lifecycle.LiveData
import androidx.room.*
import com.nduati.aadtestguide.models.Notes

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(notes : Notes)

    @Update
    suspend fun updateNote(notes: Notes)

    @Query("SELECT * FROM notes_table ORDER BY id")
    fun readAll() : LiveData<List<Notes>>

    @Query("DELETE FROM notes_table WHERE id = :id")
    suspend fun deleteByID(id : Int)

}