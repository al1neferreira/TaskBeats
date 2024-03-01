package com.comunidadedevspace.taskbeats.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.comunidadedevspace.taskbeats.TaskBeatsApplication
import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TaskListViewModel(private val taskDao: TaskDao) : ViewModel() {

    val taskListLiveData: LiveData<List<Task>> = taskDao.getAll()

    fun execute(taskAction: TaskAction) {
        when (taskAction.actionType) {
            ActionType.DELETE.name -> deleteById(taskAction.task!!.id)
            ActionType.CREATE.name -> insertIntoDatabase(taskAction.task!!)
            ActionType.UPDATE.name -> updateIntoDatabase(taskAction.task!!)
            ActionType.DELETE_ALL.name -> deleteAll()
        }

    }

    private fun deleteById(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteById(id)
        }
    }

    private fun insertIntoDatabase(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.insertTask(task)
        }
    }

    private fun updateIntoDatabase(task: Task) {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.update(task)
        }
    }

    private fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            taskDao.deleteAll()
        }
    }


    companion object {
        fun create(application: Application): TaskListViewModel {
            val dataBaseInstance = (application as TaskBeatsApplication).getAppDataBase()
            val dao = dataBaseInstance.taskDao()
            return TaskListViewModel(dao)
        }
    }
}