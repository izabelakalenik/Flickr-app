package com.example.flickr_app

import com.example.flickr_app.dataClasses.FlickrResponse
import retrofit2.Response
import retrofit2.http.GET

interface FlickrService {
    @GET("photos_public.gne?format=json&nojsoncallback=1")
    suspend fun getPublicPhotos(): Response<FlickrResponse>
}
