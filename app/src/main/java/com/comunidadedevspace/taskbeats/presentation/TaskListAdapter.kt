package com.comunidadedevspace.taskbeats.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.comunidadedevspace.taskbeats.R
import com.comunidadedevspace.taskbeats.data.Task

class TaskListAdapter(

    private val openTaskDetailView:(task: Task) -> Unit
) :
    ListAdapter<Task, TaskListViewHolder>(TaskListAdapter){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view: View = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_task, parent, false)
        return TaskListViewHolder(view)
    }
    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = getItem(position)
        holder.bind(task, openTaskDetailView)
    }
    companion object: DiffUtil.ItemCallback<Task>(){
        override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem == newItem
        }
        override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
            return oldItem.title == newItem.title &&
                    oldItem.description == newItem.description
        }
    }
}

class TaskListViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    private val tvTaskTitle = view.findViewById<TextView>(R.id.tv_task_title)
    private val tvTaskDescription = view.findViewById<TextView>(R.id.tv_task_description)

    fun bind(task: Task, openTaskDetailView:(task: Task) -> Unit) {

        tvTaskTitle.text = task.title
        tvTaskDescription.text = "${task.id}- ${task.description}"


        view.setOnClickListener {

            openTaskDetailView.invoke(task)
        }
    }
}



