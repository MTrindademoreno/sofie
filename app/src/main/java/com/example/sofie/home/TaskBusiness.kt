package com.example.sofie.home

import com.example.sofie.api.ResponseApi

class TaskBusiness {
    private val repository by lazy {
        TaskRepository()
    }


    suspend fun getTasks(): ResponseApi {
        return repository.getTasks()

    }


}