package com.example.danial_maleki_appdevtask.model

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class TaskItem(
    val id: Int,
    val title: String,
    val isChecked: MutableState<Boolean> = mutableStateOf(false)
)
