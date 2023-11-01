package com.roshanadke.checkit.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.roshanadke.checkit.domain.model.ToDo
import java.text.DateFormat

@Entity
data class ToDoEntity(
    val title: String,
    val isCompleted: Boolean,
    val timeInMillis: Long = System.currentTimeMillis(),
) {
    @PrimaryKey
    var id: Int? = null

    fun toToDo(): ToDo {
        return ToDo(
            id,
            title,
            isCompleted,
            timeInMillis
        )
    }
}
