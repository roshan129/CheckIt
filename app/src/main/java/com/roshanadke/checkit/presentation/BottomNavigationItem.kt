package com.roshanadke.checkit.presentation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material.icons.filled.CropSquare
import androidx.compose.material.icons.outlined.CheckBox
import androidx.compose.material.icons.outlined.CropSquare
import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
)

fun getBottomNavigationItemList(): List<BottomNavigationItem> {
    return listOf(
        BottomNavigationItem(
            "ToDo",
            Icons.Filled.CropSquare,
            Icons.Outlined.CropSquare,
        ),
        BottomNavigationItem(
            "Done",
            Icons.Filled.CheckBox,
            Icons.Outlined.CheckBox,
        ),
    )
}
