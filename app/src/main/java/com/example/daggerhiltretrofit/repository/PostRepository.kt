package com.example.daggerhiltretrofit.repository

import com.example.daggerhiltretrofit.models.Post
import com.example.daggerhiltretrofit.network.PostApiService
import com.example.daggerhiltretrofit.network.PostServiceImplementation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher
import javax.inject.Inject

class PostRepository
@Inject constructor(private val  postApiService: PostApiService ) {

    fun getPost():Flow<List<Post>> = flow {
        val response  = postApiService.getPost()
        emit(response)
    }.flowOn(Dispatchers.IO)

}