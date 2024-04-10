package com.comunidadedevspace.taskbeats.data.remote


import com.comunidadedevspace.taskbeats.BuildConfig
import retrofit2.http.GET

interface NewsService {

    @GET("top?api_token=${BuildConfig.API_KEY}&locale=us")
    suspend fun fetchTopNews(): NewsResponse

    @GET("all?api_token=${BuildConfig.API_KEY}")
    suspend fun fetchAllNews(): NewsResponse
}