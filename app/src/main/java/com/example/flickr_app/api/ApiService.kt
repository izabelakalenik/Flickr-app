package com.example.flickr_app.api

import com.example.flickr_app.data_classes.PhotoSearchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("?method=flickr.interestingness.getList&api_key=${ApiKey.API_KEY}&per_page=500&format=json&nojsoncallback=1&extras=date_taken,owner_name,tags,views")
    suspend fun fetchImages(): PhotoSearchResponse
}