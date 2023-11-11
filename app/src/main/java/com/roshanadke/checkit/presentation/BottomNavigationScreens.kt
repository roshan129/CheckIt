package com.roshanadke.checkit.presentation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material.icons.outlined.CropSquare
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.roshanadke.checkit.R

sealed class BottomNavigationScreens(val route: String, @StringRes val resourceId: Int, val icon: ImageVector) {
    object ToDoScreen: BottomNavigationScreens("ToDoScreen", R.string.to_do, Icons.Outlined.CropSquare)
    object DoneScreen: BottomNavigationScreens("DoneScreen", R.string.done, Icons.Outlined.CheckBox)
    object SettingsScreen: BottomNavigationScreens("SettingsScreen", R.string.settings, Icons.Outlined.Settings)
}