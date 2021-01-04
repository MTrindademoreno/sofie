package com.example.sofie.api


import com.example.sofie.model.Data
import com.example.sofie.model.TaskItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface TaskApi {
@GET("beta/task")
suspend fun getTask(): Response<TaskItem>

@Headers("Content-Type: application/json")
@POST("beta/task")
suspend fun postTask(
    @Body post:Data
):Response<Data>
}