package com.roshanadke.checkit.presentation.viewmodels

import android.util.Log
import android.view.View
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.roshanadke.checkit.data.local.entity.ToDoEntity
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.domain.repository.ToDoItemsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToDoItemsViewModel @Inject constructor(
    private val repository: ToDoItemsRepository
) : ViewModel() {

    private var _toDoList = mutableStateOf<List<ToDo>>(listOf())
    val toDoList: State<List<ToDo>> = _toDoList

    private var _finishedTasksList = mutableStateOf<List<ToDo>>(listOf())
    val finishedTasksList: State<List<ToDo>> = _finishedTasksList

    init {
        /*Log.d("TAG", " init called ")
        for(i in 1..10) {
            val item = ToDoEntity(
                "Test $i",
                false,
                System.currentTimeMillis()
            )
            viewModelScope.launch {
                repository.addToDoItem(item)
            }
        }*/
    }

    fun getIncompleteTasksList() {
        repository.getIncompleteTodos().onEach {
            _toDoList.value = it
        }.launchIn(viewModelScope)
    }

    fun getCompletedTasksList() {
        repository.getCompletedTodos().onEach {
            _finishedTasksList.value = it
        }.launchIn(viewModelScope)
    }

    fun updatedTaskIsCompleted(id: Int?, isCompleted: Boolean) {
        id?.let {
            viewModelScope.launch(Dispatchers.IO) {
                repository.updateTaskCompleted(id, isCompleted)
            }
        }
    }
}