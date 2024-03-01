package com.comunidadedevspace.taskbeats

import android.app.Application
import androidx.room.Room
import com.comunidadedevspace.taskbeats.data.AppDatabase

class TaskBeatsApplication : Application() {

    private lateinit var dataBase : AppDatabase

    override fun onCreate() {
        super.onCreate()

        dataBase = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "tasklist-database"
        ).build()
    }
    fun getAppDataBase():AppDatabase{
        return dataBase
    }
}