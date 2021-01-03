package com.example.sofie

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.sofie.api.TaskApiService
import com.example.sofie.databinding.ActivityTasksAddBinding
import com.example.sofie.model.Data
import com.example.sofie.viewModel.TaskPostviewModel

class TasksAddActivity : AppCompatActivity() {
    private lateinit var viewModel: TaskPostviewModel
    private lateinit var binding: ActivityTasksAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar.menu.setGroupEnabled(R.id.groupItem, true)

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.taskSave -> {
                    Toast.makeText(this, "save", Toast.LENGTH_LONG).show()
                    viewModel.postTasks(Data("","","ola","teste@terra.com.br","","TestePost"))

                    true
                }
                else -> false
            }
        }
    }
}