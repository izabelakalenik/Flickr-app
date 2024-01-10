package com.example.flickr_app.ui.screens

import com.example.flickr_app.main_logic.PhotoViewModel
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import com.example.flickr_app.R
import com.example.flickr_app.data_classes.Photo
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PhotoScreen(viewModel: PhotoViewModel) {
    val chosenPhoto = viewModel.chosenPhoto.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.big_spacer))
    ) {
        AppTopBar(title = stringResource(id = R.string.photo_details))
        if (chosenPhoto != null) {
            Photo(photoItem = chosenPhoto)
        }
        if (chosenPhoto != null) {
            Details(photoItem = chosenPhoto)
        }
    }

}

@Composable
fun Photo(photoItem: Photo){
    GlideImage(
        imageModel = photoItem.url,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .padding(vertical = dimensionResource(id = R.dimen.medium_padding))
            .heightIn(max = dimensionResource(id = R.dimen.enormous_image_size))
            .fillMaxWidth()
            .clip(MaterialTheme.shapes.medium)
    )
}

@Composable
fun Details(photoItem: Photo) {
    Column(
        modifier = Modifier
            .padding(dimensionResource(id = R.dimen.big_padding)),
        verticalArrangement = Arrangement.spacedBy(dimensionResource(id = R.dimen.small_spacer))
    ) {

        Text(
            text = stringResource(id = R.string.title, photoItem.title),
            fontStyle = FontStyle.Italic
        )

        Text(
            text = stringResource(id = R.string.author, photoItem.author ?: ""),
            fontStyle = FontStyle.Italic
        )

        Text(
            text = stringResource(id = R.string.date_taken, photoItem.dateTaken ?: ""),
            fontStyle = FontStyle.Italic
        )

        Text(
            text = stringResource(id = R.string.tags, photoItem.tags ?: ""),
            fontStyle = FontStyle.Italic
        )
    }
}
