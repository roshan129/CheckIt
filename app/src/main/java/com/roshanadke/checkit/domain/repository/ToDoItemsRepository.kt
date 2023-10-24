package com.roshanadke.checkit.domain.repository

import com.roshanadke.checkit.data.local.entity.ToDoEntity
import com.roshanadke.checkit.domain.model.ToDo
import kotlinx.coroutines.flow.Flow

interface ToDoItemsRepository {

    suspend fun addToDoItem(toDoEntity: ToDoEntity)

    suspend fun updateToDoItem(toDoEntity: ToDoEntity)

    fun getIncompleteTodos(): Flow<List<ToDo>>

    fun getCompletedTodos(): Flow<List<ToDo>>

}