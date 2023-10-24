package com.roshanadke.checkit.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.roshanadke.checkit.data.local.entity.ToDoEntity

@Database(
    entities = [ToDoEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ToDoDatabase: RoomDatabase() {

    abstract fun getToDoListDao(): TodoListDao

}