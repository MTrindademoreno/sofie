package com.example.sofie.home

import com.example.sofie.api.ResponseApi
import com.example.sofie.api.TaskApiService


class TaskRepository {

    suspend fun getTasks():ResponseApi {

        return try {
            val response1 =TaskApiService.taskApi.getTask()
            if (response1.isSuccessful) {

                ResponseApi.Success(response1.body())

            } else {
                ResponseApi.Error("Erro ao carregar os dados")

            }

        } catch (exception: Exception) {
            ResponseApi.Error("Erro ao carregar os dados")
        }
    }

}