package com.example.sofie.view

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sofie.adapter.MainAdpter
import com.example.sofie.databinding.ActivityMainBinding
import com.example.sofie.model.Data
import com.example.sofie.viewModel.TaskGetViewModel

class MainActivity : AppCompatActivity() {
    private val tasklist = mutableListOf<Data>()
    private val mainAdpter: MainAdpter by lazy {
        MainAdpter(tasklist)
    }

    private lateinit var viewModel: TaskGetViewModel
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this).get(TaskGetViewModel::class.java)

        binding.fabAddTask.setOnClickListener {
            val intent = Intent(this, TasksAddActivity::class.java)
            startActivity(intent)
        }

        setupRecyclerView()



    }

    override fun onResume() {
        super.onResume()
        loadContent()


    }

    private fun setupRecyclerView() {
        binding.rvTasks.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mainAdpter
        }
    }

    private fun loadContent() {
        viewModel.getTask()
        viewModel.task.observe(this, {
            tasklist.clear()
            tasklist.addAll(it.data)
            mainAdpter.notifyDataSetChanged()


        })

    }
}