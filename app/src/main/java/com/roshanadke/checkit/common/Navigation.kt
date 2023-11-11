package com.roshanadke.checkit.common

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roshanadke.checkit.presentation.BottomNavigationScreens
import com.roshanadke.checkit.presentation.screens.FinishedTasksScreen
import com.roshanadke.checkit.presentation.screens.MainScreen
import com.roshanadke.checkit.presentation.screens.SettingsScreen
import com.roshanadke.checkit.presentation.screens.ToDoCheckListScreen

@Composable
fun Navigation(modifier: Modifier, navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = BottomNavigationScreens.ToDoScreen.route,
        modifier = modifier
    ) {
        composable(route = BottomNavigationScreens.ToDoScreen.route) {
            ToDoCheckListScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = BottomNavigationScreens.DoneScreen.route
        ) {
            FinishedTasksScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        composable(
            route = BottomNavigationScreens.SettingsScreen.route
        ) {
            SettingsScreen(
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }


}