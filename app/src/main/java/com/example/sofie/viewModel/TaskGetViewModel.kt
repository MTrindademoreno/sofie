package com.example.sofie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sofie.api.ResponseApi
import com.example.sofie.home.TaskBusiness
import com.example.sofie.model.TaskItem
import kotlinx.coroutines.launch

class TaskGetViewModel:ViewModel() {
    private var business = TaskBusiness()
    val task:MutableLiveData<TaskItem> = MutableLiveData()
    val erro:MutableLiveData<String> = MutableLiveData()

    fun getTask(){
        viewModelScope.launch {
            when(val response = business.getTasks()){
                is ResponseApi.Success ->{

                    task.postValue(
                        response.data as? TaskItem
                    )
                }
                is ResponseApi.Error->{
                    erro.postValue(response.message)

                }
            }
        }
    }
}