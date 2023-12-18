package com.example.flickr_app.dataClasses

import com.google.gson.annotations.SerializedName

data class FlickrResponse(
    val items: List<FlickrItem>
)

data class FlickrItem(
    val title: String,
    val link: String,
    @SerializedName("media") val media: FlickrMedia
)

data class FlickrMedia(
    @SerializedName("m") val imageUrl: String
)