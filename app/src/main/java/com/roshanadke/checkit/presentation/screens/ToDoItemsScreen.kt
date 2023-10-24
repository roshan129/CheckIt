package com.roshanadke.checkit.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {

            LazyColumn {
                items(toDoList) {
                    Text(text = it.title)
                }
            }

        }
    }


}