package com.nduati.aadtestguide.datamanagement

import android.provider.UserDictionary
import com.nduati.aadtestguide.models.Notes

class NoteRepository(private val notesDao: NotesDao) {
    val allNotes = notesDao.readAll()

    suspend fun insert(notes: Notes){
        notesDao.addNote(notes)
    }

    suspend fun update(notes: Notes){
        notesDao.updateNote(notes)
    }

    suspend fun delete(pos: Int){
        notesDao.deleteByID(pos)
    }

}