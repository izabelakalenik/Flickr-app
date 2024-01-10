package com.example.flickr_app.data_classes

data class Photo(
    val id: String,
    val url: String,
    val title: String,
    val dateTaken: String?,
    val author: String?,
    val tags: String?,
)