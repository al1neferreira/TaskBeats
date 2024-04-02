package com.comunidadedevspace.taskbeats.data.remote


import retrofit2.http.GET

interface NewsService {

    @GET("news?category= science")
    suspend fun fetchNews(): NewsResponse
}