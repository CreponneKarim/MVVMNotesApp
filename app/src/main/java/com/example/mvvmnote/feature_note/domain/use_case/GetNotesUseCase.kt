package com.example.mvvmnote.feature_note.domain.use_case

import com.example.mvvmnote.feature_note.domain.model.Note
import com.example.mvvmnote.feature_note.domain.repository.NoteRepository
import com.example.mvvmnote.feature_note.domain.util.NoteOrder
import com.example.mvvmnote.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNotesUseCase(
    private val repository: NoteRepository
) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ): Flow<List<Note>> {

        return repository.getNotes().map { notes ->
            when(noteOrder.orderType){
                OrderType.Descending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedByDescending { it.title.lowercase() }
                        is NoteOrder.Date  -> notes.sortedByDescending { it.title }
                        is NoteOrder.Color -> notes.sortedByDescending { it.color }
                    }
                }
                OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Title -> notes.sortedBy { it.title.lowercase() }
                        is NoteOrder.Date  -> notes.sortedBy { it.title }
                        is NoteOrder.Color -> notes.sortedBy { it.color }
                    }
                }
            }
        }
    }
}