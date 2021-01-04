package com.example.sofie.view

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.sofie.R
import com.example.sofie.databinding.ActivityTasksAddBinding
import com.example.sofie.model.Data
import com.example.sofie.utils.Validation
import com.example.sofie.viewModel.TaskPostviewModel

class TasksAddActivity : AppCompatActivity() {

    private lateinit var viewModel: TaskPostviewModel
    private lateinit var binding: ActivityTasksAddBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTasksAddBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(TaskPostviewModel::class.java)



        initComponents()
    }

    private fun verifyInput(): Boolean {
        val mEmail = binding.edtMailTask
        val mTitle = binding.edtNameTask
        val mDescription = binding.edtDescriptionTask
        val tilEmail = binding.tilEmailTask
        val tilTitle = binding.tilNameTask
        val tilDescription = binding.tilDescriptionTask

        Validation(this).apply {
            return isEmailValid(mEmail, tilEmail)
                    && isEditTextFilled(mTitle, tilTitle, getString(R.string.title))
                    && isEditTextFilled(
                mDescription,
                tilDescription,
                getString(R.string.descrition)
            )


        }
    }

    private fun initComponents() {
        binding.topAppBar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.taskSave -> {

                    if (verifyInput()) {
                        postTask()


                    }


                    true
                }
                else -> false
            }
        }

        binding.topAppBar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun postTask() {

        val email = binding.edtMailTask.editableText.toString()
        val title = binding.edtNameTask.editableText.toString()
        val description = binding.edtDescriptionTask.editableText.toString()
        viewModel.postTasks(Data(description, email, title))
        clearInput()
        Toast.makeText(this, "Salvo", Toast.LENGTH_SHORT).show()

    }

    private fun clearInput() {
        binding.edtMailTask.text?.clear()
        binding.edtDescriptionTask.text?.clear()
        binding.edtNameTask.text?.clear()
    }


}