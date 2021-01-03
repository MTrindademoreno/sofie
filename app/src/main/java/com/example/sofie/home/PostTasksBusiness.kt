package com.example.sofie.home

import com.example.sofie.api.ResponseApi
import com.example.sofie.model.Data
import okhttp3.Response

class PostTasksBusiness {
    private val repository by lazy {
        PostsTasksRepository()
    }

    suspend fun postTasks(post: Data):ResponseApi{
        return repository.postTasks(post)
    }


}