package com.example.flickr_app.main_logic

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flickr_app.data_classes.Photo
import com.example.flickr_app.api.WebClient
import kotlinx.coroutines.launch

class PhotoViewModel : ViewModel() {
    private val _photoLiveData: MutableState<List<Photo>> = mutableStateOf(emptyList())
    val photosLiveData: MutableState<List<Photo>> = _photoLiveData

    val chosenPhoto = mutableStateOf<Photo?>(null)

    fun loadPhotos() {
        viewModelScope.launch {
            val searchResponse = WebClient.client.fetchImages()
            val photosList = searchResponse.photos.photo.map { photo ->
                val imageUrl =
                    "https://farm${photo.farm}.staticflickr.com/${photo.server}/${photo.id}_${photo.secret}.jpg"

                Photo(
                    id = photo.id,
                    url = imageUrl,
                    title = photo.title,
                    dateTaken = photo.datetaken,
                    author = photo.ownername,
                    tags = photo.tags,
                )
            }
            _photoLiveData.value = photosList
        }
    }

    fun changeSelectedPhoto(photo: Photo) {
        chosenPhoto.value = photo
    }
}