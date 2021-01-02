package com.example.sofie

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.sofie.databinding.ActivityTasksAddBinding

class TasksAddActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTasksAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.topAppBar.setNavigationOnClickListener {
            Toast.makeText(this, "ok", Toast.LENGTH_LONG).show()
        }

        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.taskSave -> {
                    Toast.makeText(this, "save", Toast.LENGTH_LONG).show()
                    true
                }
                else -> false
            }
        }
    }
}