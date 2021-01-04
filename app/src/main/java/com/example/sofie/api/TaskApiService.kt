package com.example.sofie.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object TaskApiService {
    val taskApi = getTask().create(TaskApi::class.java)
    private fun getTask(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://9g1borgfz0.execute-api.sa-east-1.amazonaws.com/")
            .client(getInterceptorClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    }

    private fun getInterceptorClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val interceptor = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .readTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(10, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor)
        return interceptor.build()
    }


}