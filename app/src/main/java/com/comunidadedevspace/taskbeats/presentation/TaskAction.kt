package com.comunidadedevspace.taskbeats.presentation

import com.comunidadedevspace.taskbeats.data.local.Task
import java.io.Serializable

enum class ActionType {
    DELETE,
    UPDATE,
    CREATE,
    DELETE_ALL
}

data class TaskAction(
    val task: Task?,
    val actionType: String
) : Serializable