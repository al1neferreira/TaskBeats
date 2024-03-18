package com.comunidadedevspace.taskbeats.presentation

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.comunidadedevspace.taskbeats.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class NewMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_main)

        val bottonNavView = findViewById<BottomNavigationView>(R.id.bottom_nav_view)

        val taskListFragment = TaskListFragment.newInstance()
        val newsListFragment = NewsListFragment.newInstance()

        supportFragmentManager.commit {
            replace(R.id.fragment_container_view, taskListFragment)
            setReorderingAllowed(true)

        }

        bottonNavView.setOnItemSelectedListener { menuItem ->
          val fragment = when(menuItem.itemId){
                R.id.task_list -> taskListFragment
                R.id.news_list -> newsListFragment

               else -> taskListFragment

            }
            supportFragmentManager.commit {
                replace(R.id.fragment_container_view, fragment)
                setReorderingAllowed(true)
            }
            true
        }
    }
}
