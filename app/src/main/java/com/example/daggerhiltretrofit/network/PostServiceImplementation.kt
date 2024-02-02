package com.example.daggerhiltretrofit.network

import com.example.daggerhiltretrofit.models.Post
import javax.inject.Inject

class PostServiceImplementation @Inject constructor(private val postApiService: PostApiService) {

    suspend fun getPost() : List<Post> = postApiService.getPost()
}