package com.example.sofie.home

import com.example.sofie.api.ResponseApi
import com.example.sofie.api.TaskApiService
import com.example.sofie.model.Data

class PostsTasksRepository {


suspend fun postTasks(post:Data):ResponseApi {


    return try {
        val response =TaskApiService.taskApi.postTask(post)

        if (response.isSuccessful) {

            ResponseApi.Success(response.code())

        } else {
            ResponseApi.Error("Erro ao carregar os dados")

        }

    } catch (exception: Exception) {
        ResponseApi.Error("Erro ao carregar os dados")
    }
}

}