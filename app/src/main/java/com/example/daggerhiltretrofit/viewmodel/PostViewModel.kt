package com.example.daggerhiltretrofit.viewmodel

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.ViewModelFactoryDsl
import com.example.daggerhiltretrofit.models.Post
import com.example.daggerhiltretrofit.repository.PostRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch


@Suppress("DEPRECATION")
class PostViewModel @ViewModelInject constructor(private  val postRepository: PostRepository) : ViewModel() {

    val postLiveData : MutableLiveData<List<Post>> = MutableLiveData()

    fun getPost(){
        viewModelScope.launch {
            postRepository.getPost()
                .catch {e->
                    Log.d("main", "getPost: ${e.message}")
                }.collect {response->
                    postLiveData.value=response
                }

        }
    }
}

