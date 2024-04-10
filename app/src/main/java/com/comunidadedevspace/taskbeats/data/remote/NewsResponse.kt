package com.comunidadedevspace.taskbeats.data.remote

import com.google.gson.annotations.SerializedName

data class NewsResponse (
    val data: List<NewsDTO>
)

data class NewsDTO(
    @SerializedName("uuid")
    val id: String,
    @SerializedName("snippet")
    val content:String,
    @SerializedName("image_url")
    val imageUrl: String,
    val title: String
)