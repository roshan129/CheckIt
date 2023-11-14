package com.roshanadke.checkit.data.local

import com.roshanadke.checkit.data.local.entity.ToDoEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class TodoListDaoFake: TodoListDao {

    var entityList : MutableList<ToDoEntity> = mutableListOf()

    override suspend fun addToDo(toDoEntity: ToDoEntity) {
        entityList.add(toDoEntity)
    }

    override suspend fun updateToDo(toDoEntity: ToDoEntity) {
        entityList = entityList.map {
            if(toDoEntity.id == it.id) {
                toDoEntity
            } else {
                it
            }
        }.toMutableList()
    }

    override fun getIncompleteTodos(): Flow<List<ToDoEntity>> {
        return flow { entityList.map { !it.isCompleted } }
    }

    override fun getCompletedTodos(): Flow<List<ToDoEntity>> {
        return flow { entityList.map { it.isCompleted } }
    }

    override fun updateTaskIsCompleteById(recordId: Int, isCompleted: Boolean) {
        entityList.map {
            if(recordId == it.id) {
                it.copy(isCompleted = isCompleted)
            } else {
                it
            }
        }
    }


}