package com.nduati.aadtestguide.datamanagement

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.nduati.aadtestguide.models.Notes
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NoteViewModel(application: Application) : AndroidViewModel(application) {
    private val repository : NoteRepository
    val allNotes : LiveData<List<Notes>>

    init {
        val notesDao = NotesDatabase.getDatabase(application, viewModelScope).notesDao()
        repository = NoteRepository(notesDao)
        allNotes = repository.allNotes
    }

    fun addNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(notes)
    }

    fun deleteById(id : Int) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(id)
    }

    fun updateNote(notes: Notes) = viewModelScope.launch(Dispatchers.IO){
        repository.update(notes)
    }
}