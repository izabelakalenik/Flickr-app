package com.example.flickr_app.data_classes

data class PhotoSearchResponse(
    val photos: PhotoMetaData
)

data class PhotoMetaData(
    val page: Int,
    val photo: List<PhotoResponse>
)

data class PhotoResponse(
    val id: String,
    val owner: String,
    val secret: String,
    val server: String,
    val farm: Int,
    val title: String,
    val datetaken: String?,
    val ownername: String?,
    val tags: String?,
    val views: String?
)