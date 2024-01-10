package com.example.flickr_app.main_logic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.ViewModelProvider


class MainActivity : ComponentActivity() {
    private val photoViewModel: PhotoViewModel by lazy {
        ViewModelProvider(this)[PhotoViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation(photoViewModel = photoViewModel)
        }
    }
}