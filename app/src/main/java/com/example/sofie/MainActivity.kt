package com.example.sofie

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sofie.adapter.MainAdpter
import com.example.sofie.databinding.ActivityMainBinding
import com.example.sofie.viewModel.TaskGetViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: TaskGetViewModel
    private lateinit var adapter: MainAdpter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)




        binding.fabAddTask.setOnClickListener {
            val intent = Intent(this, TasksAddActivity::class.java)
            startActivity(intent)
        }
        viewModel = ViewModelProvider(this).get(TaskGetViewModel::class.java)
        viewModel.getTask()
        viewModel.task.observe(this, Observer {
            binding.rvTasks.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = MainAdpter(it)
            }

        })


    }
}