package com.example.daggerhiltretrofit.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.daggerhiltretrofit.models.Post
import com.example.daggerhiltretrofit.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PostViewModel @Inject constructor(private  val postRepository: PostRepository) : ViewModel() {

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

