package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.TaskBeatsApplication
import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskDetailViewModel(
    private val taskDao: TaskDao,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO
) : ViewModel() {
    fun execute(taskAction: TaskAction) {
        when (taskAction.actionType) {
            ActionType.DELETE.name -> deleteById(taskAction.task!!.id)
            ActionType.CREATE.name -> insertIntoDatabase(taskAction.task!!)
            ActionType.UPDATE.name -> updateIntoDatabase(taskAction.task!!)
        }

    }

    private fun deleteById(id: Int) {
        viewModelScope.launch(dispatcher) {
            taskDao.deleteById(id)
        }
    }

    private fun insertIntoDatabase(task: Task) {
        viewModelScope.launch(dispatcher) {
            taskDao.insertTask(task)
        }
    }

    private fun updateIntoDatabase(task: Task) {
        viewModelScope.launch(dispatcher) {
            taskDao.update(task)
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