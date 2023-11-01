package com.roshanadke.checkit.domain.model

import java.text.DateFormat

data class ToDo(
    val id: Int? = null,
    val title: String,
    val isCompleted: Boolean,
    val timeInMillis: Long = System.currentTimeMillis(),
) {
    val createdDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(timeInMillis)
}