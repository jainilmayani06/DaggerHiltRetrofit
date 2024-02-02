package com.example.daggerhiltretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.daggerhiltretrofit.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val postViewModel:PostViewModel = TODO()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel.getPost()

        postViewModel.postLiveData.observe(this, Observer {response->
            Log.d("main", response[0].body)
        })

    }
}