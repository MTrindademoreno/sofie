package com.example.sofie.model

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("_id")
    val id: String?="",
    val changed: String?,
    val description: String?="",
    val email: String?="",
    val quando: String?,
    val title: String?="",
   // val `when`: String
)