package com.roshanadke.checkit.data.repository

import com.roshanadke.checkit.data.local.TodoListDao
import com.roshanadke.checkit.data.local.entity.ToDoEntity
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.domain.repository.ToDoItemsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class ToDoItemsRepositoryImpl(
    private val dao: TodoListDao
) : ToDoItemsRepository {
    override suspend fun addToDoItem(toDoEntity: ToDoEntity) {
        dao.addToDo(toDoEntity)
    }

    override suspend fun updateToDoItem(toDoEntity: ToDoEntity) {
        dao.updateToDo(toDoEntity)
    }

    override suspend fun updateTaskCompleted(id: Int, isCompleted: Boolean) {
        dao.updateTaskIsCompleteById(id, isCompleted)
    }

    override fun getIncompleteTodos(): Flow<List<ToDo>> = flow {
        dao.getIncompleteTodos().map {
            it.map { toDoEntity ->
                toDoEntity.toToDo()
            }
        }.collect {
            emit(it)
        }
    }

    override fun getCompletedTodos(): Flow<List<ToDo>> = flow {
        dao.getCompletedTodos().map {
            it.map { toDoEntity ->
                toDoEntity.toToDo()
            }
        }.collect {
            emit(it)
        }
    }
}