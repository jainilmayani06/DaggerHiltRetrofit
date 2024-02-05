package com.example.daggerhiltretrofit

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.example.daggerhiltretrofit.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val postViewModel:PostViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        postViewModel.getPost()

        postViewModel.postLiveData.observe(this, Observer {response->

            for(i in response){
                Log.d("main", response[0].body)
                Toast.makeText(this, i.body, Toast.LENGTH_SHORT).show()
            }
        })

    }
}