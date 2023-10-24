package com.roshanadke.checkit.presentation

sealed class Screen(val route: String) {
    object ToDoItemsScreen: Screen("ToDoItemsScreen")
    object FinishedTasksScreen: Screen("FinishedTasksScreen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}