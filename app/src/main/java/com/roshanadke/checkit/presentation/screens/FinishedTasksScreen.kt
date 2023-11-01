package com.roshanadke.checkit.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.presentation.components.ToDoCheckListIem

@Composable
fun FinishedTasksScreen(
    modifier: Modifier,
    finishedTasksList: List<ToDo>,
    onItemChecked: (isChecked: Boolean, id: Int?) -> Unit
) {

    Box(
        modifier = modifier
    ) {

        LazyColumn {
            items(finishedTasksList) {
                ToDoCheckListIem(
                    taskItem = it,
                    onItemChecked = onItemChecked
                )
            }
        }

    }

}