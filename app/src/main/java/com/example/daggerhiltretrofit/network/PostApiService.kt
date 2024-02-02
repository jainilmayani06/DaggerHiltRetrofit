package com.example.daggerhiltretrofit.network

import com.example.daggerhiltretrofit.models.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getPost() : List<Post>
}