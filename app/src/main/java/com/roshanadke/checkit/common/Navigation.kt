package com.roshanadke.checkit.common

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.roshanadke.checkit.presentation.Screen
import com.roshanadke.checkit.presentation.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.ToDoItemsScreen.route) {
        composable(route = Screen.ToDoItemsScreen.route) {
            MainScreen(navController = navController)
        }

        composable(
            route = Screen.FinishedTasksScreen.route + "/{id}",
           /* arguments = listOf(
                navArgument("id") {
                    type = NavType.IntType
                    defaultValue = 0
                }
            )*/
        ) { navBackStackEntry ->
            val recipeId = navBackStackEntry.arguments?.getInt("id")
            //RecipeDetailsScreen(recipeId)
        }
    }


}