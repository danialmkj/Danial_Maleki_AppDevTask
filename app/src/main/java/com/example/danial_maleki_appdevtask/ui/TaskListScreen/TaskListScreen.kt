package com.example.danial_maleki_appdevtask.ui.TaskListScreen

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.danial_maleki_appdevtask.model.TaskItem

@Composable
fun TaskListScreen(
    modifier: Modifier = Modifier
) {
    // Static list of three tasks — stored in a mutableStateList to show mapping
    val taskList = remember {
        mutableStateListOf(
            TaskItem(1, "Buy groceries"),
            TaskItem(2, "Call client about brief"),
            TaskItem(3, "Prepare slides for meeting")
        )
    }

    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)) {

            // Header
            Text(
                text = "My Tasks",
                style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(16.dp))

            // List
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                taskList.forEach { task ->
                    TaskRow(
                        task = task,
                        onToggle = {
                            // toggle state directly on the TaskItem model
                            task.isChecked.value = !task.isChecked.value
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun TaskRow(task: TaskItem, onToggle: (TaskItem) -> Unit) {
    // subtle polish: animate the text alpha when checked
    val alphaAnim by animateFloatAsState(if (task.isChecked.value) 0.6f else 1f)

    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = task.isChecked.value,
                onCheckedChange = { onToggle(task) }
            )

            Spacer(modifier = Modifier.width(12.dp))

            val decoration = if (task.isChecked.value) TextDecoration.LineThrough else TextDecoration.None
            Text(
                text = task.title,
                modifier = Modifier
                    .weight(1f)
                    .alpha(alphaAnim),
                style = MaterialTheme.typography.bodyLarge.copy(textDecoration = decoration)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewTaskList() {
    TaskListScreen()
}
