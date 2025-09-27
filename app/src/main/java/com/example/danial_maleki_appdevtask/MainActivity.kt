package com.example.danial_maleki_appdevtask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.danial_maleki_appdevtask.ui.TaskListScreen.TaskListScreen
import com.example.danial_maleki_appdevtask.ui.theme.Danial_Maleki_AppDevTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Danial_Maleki_AppDevTaskTheme {
                TaskListScreen(modifier = Modifier.fillMaxSize())
            }
        }
    }
}
