package com.example.sofie.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sofie.home.PostTasksBusiness
import com.example.sofie.model.Data
import kotlinx.coroutines.launch

class TaskPostviewModel:ViewModel() {
    private val business = PostTasksBusiness()
val tasks:MutableLiveData<Data> = MutableLiveData()

    fun postTasks(post:Data){
      viewModelScope.launch {
          business.postTasks(post)


      }
    }
}