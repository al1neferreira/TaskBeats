package com.comunidadedevspace.taskbeats

import com.comunidadedevspace.taskbeats.data.Task
import com.comunidadedevspace.taskbeats.data.TaskDao
import com.comunidadedevspace.taskbeats.presentation.ActionType
import com.comunidadedevspace.taskbeats.presentation.TaskAction
import com.comunidadedevspace.taskbeats.presentation.TaskListViewModel
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class TaskListViewModelTest {

    private val taskDao: TaskDao = mock()

    private val underTest: TaskListViewModel by lazy {
        TaskListViewModel(taskDao,
            UnconfinedTestDispatcher()
        )
    }

    @Test
    fun delete_all() = runTest {

        val taskAction = TaskAction(
            task = null,
            actionType = ActionType.DELETE_ALL.name
        )
        underTest.execute(taskAction)

        verify(taskDao).deleteAll()

    }

    @Test
    fun update_task() = runTest {

        val task = Task(
            id = 0,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.UPDATE.name
        )
        underTest.execute(taskAction)

        verify(taskDao).update(task)

    }

    @Test
    fun delete_task() = runTest{
        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.DELETE.name
        )
        underTest.execute(taskAction)

        verify(taskDao).deleteById(task.id)

    }
    @Test
    fun create_task() = runTest{

        val task = Task(
            id = 1,
            title = "title",
            description = "description"
        )

        val taskAction = TaskAction(
            task = task,
            actionType = ActionType.CREATE.name
        )
        underTest.execute(taskAction)

        verify(taskDao).insertTask(task)

    }

}

