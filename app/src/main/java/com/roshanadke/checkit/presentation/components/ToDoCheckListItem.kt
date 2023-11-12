package com.roshanadke.checkit.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.roshanadke.checkit.domain.model.ToDo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun ToDoCheckListIem(
    taskItem: ToDo,
    onItemChecked: (isChecked: Boolean, id: Int?) -> Unit
) {
    var isChecked by remember {
        mutableStateOf(taskItem.isCompleted)
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
                CoroutineScope(Dispatchers.Main).launch {
                    isChecked = !isChecked
                    delay(300L)
                    onItemChecked(!isChecked, taskItem.id)
                    isChecked = !isChecked
                }

            })
            Spacer(modifier = Modifier.width(16.dp))
            Text(text = taskItem.title)
        }

        IconButton(
            onClick = {

            },
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Icon(imageVector = Icons.Default.MoreVert, contentDescription = "Task Item Menu")
        }

    }

}