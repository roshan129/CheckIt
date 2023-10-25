package com.roshanadke.checkit.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.roshanadke.checkit.domain.model.ToDo
import com.roshanadke.checkit.presentation.getBottomNavigationItemList
import com.roshanadke.checkit.presentation.viewmodels.ToDoItemsViewModel
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToDoItemsScreen(
    navController: NavController,
    viewModel: ToDoItemsViewModel = hiltViewModel()
) {

    var selectedItemIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    val toDoList by viewModel.toDoList

    LaunchedEffect(Unit) {
        delay(500L)
        viewModel.getIncompleteTasksList()
    }

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "CheckIt")
            })
        },
        bottomBar = {
            NavigationBar {
                getBottomNavigationItemList().forEachIndexed { index, bottomNavigationItem ->
                    NavigationBarItem(selected = selectedItemIndex == index, onClick = {
                        selectedItemIndex = index
                    }, icon = {
                        Icon(
                            imageVector = if (selectedItemIndex == index) {
                                bottomNavigationItem.selectedIcon
                            } else bottomNavigationItem.unselectedIcon,
                            contentDescription = bottomNavigationItem.title
                        )
                    }, label = {
                        Text(text = bottomNavigationItem.title)
                    })

                }
            }
        }
    ) {

        if(selectedItemIndex == 0) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {

                LazyColumn {
                    items(toDoList) {
                        ToDoCheckListIem(taskItem = it)

                    }
                }

            }
        } else if(selectedItemIndex == 1) {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Task Done Screen")
            }
        } else {
            Column(
                Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Settings Screen")
            }
        }
    }
}


@Composable
fun ToDoCheckListIem(
    taskItem: ToDo,
) {
    var isChecked by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Spacer(modifier = Modifier.width(16.dp))
            Checkbox(checked = isChecked, onCheckedChange = {
                isChecked = !isChecked
            })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = taskItem.title)
        }

        IconButton(onClick = {

        },
            modifier = Modifier.padding(end = 16.dp)) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Task Item Menu")
        }

    }

}