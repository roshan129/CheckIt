package com.roshanadke.checkit.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.presentation.components.ToDoCheckListIem
import com.roshanadke.checkit.presentation.viewmodels.ToDoItemsViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay

@Composable
fun ToDoCheckListScreen(
    modifier: Modifier,
    viewModel: ToDoItemsViewModel = hiltViewModel(),
) {

    val toDoList by viewModel.toDoList

    LaunchedEffect(Unit) {
        viewModel.getIncompleteTasksList()
    }


    Box(
        modifier = modifier
    ) {

        LazyColumn {
            items(toDoList) {
                ToDoCheckListIem(
                    taskItem = it,
                    onItemChecked = { isChecked: Boolean, id: Int? ->
                        viewModel.updatedTaskIsCompleted(id, true)
                    }
                )

            }
        }

    }
}

