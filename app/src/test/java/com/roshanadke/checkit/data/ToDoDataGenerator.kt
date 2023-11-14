package com.roshanadke.checkit.data

import com.roshanadke.checkit.data.local.entity.ToDoEntity
import okhttp3.internal.notify

fun getToDoEntityList(): List<ToDoEntity> {
    val list = listOf(
        ToDoEntity(
            title = "Test title one",
            isCompleted = false,
        ),
        ToDoEntity(
            title = "Test title two",
            isCompleted = false
        ),
        ToDoEntity(
            title = "Test title three",
            isCompleted = false
        ),
    )
    list[0].id = 1
    list[1].id = 2
    list[2].id = 3

    return list
}