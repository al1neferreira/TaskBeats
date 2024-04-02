package com.comunidadedevspace.taskbeats.data.remote

class NewsResponse (

    val category: String,
    val data: List<NewsDTO>



)

data class NewsDTO(
    val id: String,
    val content:String,
    val imageUrl: String,
    val title: String
)