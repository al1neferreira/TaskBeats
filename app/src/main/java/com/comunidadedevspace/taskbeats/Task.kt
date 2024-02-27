package com.comunidadedevspace.taskbeats

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity

data class Task(
    @PrimaryKey(autoGenerate = true)

    val id: Int=0,
    var title: String,
    var description: String
): Serializable



