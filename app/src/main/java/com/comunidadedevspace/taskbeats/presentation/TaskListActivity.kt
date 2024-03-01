package com.comunidadedevspace.taskbeats.presentation

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.Task
import com.google.android.material.snackbar.Snackbar
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private lateinit var ctnContent: LinearLayout

    private val adapter: TaskListAdapter by lazy {
        TaskListAdapter(::onListItemClicked)
    }

    private val viewModel: TaskListViewModel by lazy {
        TaskListViewModel.create(application)
    }


    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()

    ) { result: ActivityResult ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            val taskAction = data?.getSerializableExtra(TASK_ACTION_RESULT) as TaskAction

            viewModel.execute(taskAction)

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)
        setSupportActionBar(findViewById(R.id.toolbar))

        ctnContent = findViewById(R.id.ctn_content)

        val rvTasks: RecyclerView = findViewById(R.id.rv_task_list)
        rvTasks.adapter = adapter

        val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            openTaskListDetail(null)
        }
    }

    override fun onStart() {
        super.onStart()
        listFromDataBase()
    }

    private fun deleteAll() {
        val taskAction = TaskAction(null, ActionType.DELETE_ALL.name)
        viewModel.execute(taskAction)
    }


    private fun listFromDataBase() {
        val listObserver = Observer<List<Task>> { listTasks ->

            if (listTasks.isEmpty()){
                ctnContent.visibility = View.VISIBLE
            }else{
                ctnContent.visibility = View.GONE
            }

            adapter.submitList(listTasks)
        }
        viewModel.taskListLiveData.observe(this@MainActivity, listObserver)
    }

    private fun showMessage(view: View, message: String) {
        Snackbar.make(view, message, Snackbar.LENGTH_LONG)
            .setAction("Action", null)
            .show()
    }

    private fun onListItemClicked(task: Task) {
        openTaskListDetail(task)
    }

    private fun openTaskListDetail(task: Task? = null) {
        val intent = TaskDetailActivity.start(this, task)
        startForResult.launch(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_tasklist_delete_all, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.delete_alltasks -> {
                deleteAll()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }
}

enum class ActionType {
    DELETE,
    DELETE_ALL,
    UPDATE,
    CREATE
}

data class TaskAction(
    val task: Task?,
    val actionType: String
) : Serializable

const val TASK_ACTION_RESULT = "TASK_ACTION_RESULT"


