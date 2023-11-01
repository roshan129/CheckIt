package com.roshanadke.checkit.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.presentation.components.ToDoCheckListIem

@Composable
fun ToDoCheckListScreen(
    modifier: Modifier,
    toDoList: List<ToDo>,
    onItemChecked: (isChecked: Boolean, id: Int?) -> Unit
) {
    Box(
        modifier = modifier
    ) {

        LazyColumn {
            items(toDoList) {
                ToDoCheckListIem(
                    taskItem = it,
                    onItemChecked = onItemChecked
                )

            }
        }

    }
}

