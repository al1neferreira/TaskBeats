package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.TaskBeatsApplication
import com.comunidadedevspace.taskbeats.data.local.Task
import com.comunidadedevspace.taskbeats.data.local.TaskDao
import kotlinx.coroutines.launch

class TaskDetailViewModel(
    private val taskDao: TaskDao
) : ViewModel() {

    fun execute(taskAction: TaskAction) {
        when (taskAction.actionType) {
            ActionType.DELETE.name -> deleteById(taskAction.task!!.id)
            ActionType.CREATE.name -> insertIntoDatabase(taskAction.task!!)
            ActionType.UPDATE.name -> updateIntoDatabase(taskAction.task!!)
            ActionType.DELETE_ALL.name ->deleteAll(taskAction.task!!)
        }

    }

    private fun deleteById(id: Int) {
        viewModelScope.launch {
            taskDao.deleteById(id)
        }
    }

    private fun insertIntoDatabase(task: Task) {
        viewModelScope.launch {
            taskDao.insert(task)
        }
    }

    private fun updateIntoDatabase(task: Task) {
        viewModelScope.launch {
            taskDao.update(task)
        }
    }

    private fun deleteAll(task:Task){
        viewModelScope.launch {
            taskDao.deleteAll()
        }
    }

    companion object {

        fun getVMFactory(application: Application): ViewModelProvider.Factory {
            val dataBaseInstance = (application as TaskBeatsApplication).getAppDataBase()

            val dao = dataBaseInstance.taskDao()

            val factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return TaskDetailViewModel(dao) as T
                }

            }
            return factory

        }

    }
}