package com.example.mvvmnote.feature_note.domain.use_case

import com.example.mvvmnote.feature_note.domain.model.InvalidNoteException
import com.example.mvvmnote.feature_note.domain.model.Note
import com.example.mvvmnote.feature_note.domain.repository.NoteRepository
import kotlin.jvm.Throws

class AddNoteUseCase(
    private val repository: NoteRepository
) {
    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note)
    {
        if(note.title.isBlank()) throw InvalidNoteException("The title of the node can't be empty.")
        if(note.content.isBlank()) throw InvalidNoteException("The content of the node can't be empty.")

        repository.insertNote(note)
    }
}