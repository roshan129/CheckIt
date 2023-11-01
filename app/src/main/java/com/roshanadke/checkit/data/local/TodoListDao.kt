package com.roshanadke.checkit.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.roshanadke.checkit.data.local.entity.ToDoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TodoListDao {
    @Insert
    suspend fun addToDo(toDoEntity: ToDoEntity)

    @Update
    suspend fun updateToDo(toDoEntity: ToDoEntity)

    //@Query("SELECT * FROM todos WHERE isCompleted = :completed")

    @Query("SELECT * FROM ToDoEntity WHERE isCompleted = 0")
    fun getIncompleteTodos(): Flow<List<ToDoEntity>>

    @Query("SELECT * FROM ToDoEntity WHERE isCompleted = 1")
    fun getCompletedTodos(): Flow<List<ToDoEntity>>

    @Query("UPDATE ToDoEntity SET isCompleted = :newFieldValue WHERE id = :recordId")
    fun updateTaskIsCompleteById(recordId: Int, newFieldValue: Boolean)

}