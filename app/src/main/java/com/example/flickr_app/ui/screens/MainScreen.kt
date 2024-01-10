import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.example.flickr_app.R
import com.example.flickr_app.data_classes.Photo
import com.example.flickr_app.ui.screens.AppTopBar
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.flickr_app.main_logic.PHOTO_SCREEN_ROUTE
import com.example.flickr_app.main_logic.PhotoViewModel


@Composable
fun MainScreen(viewModel: PhotoViewModel, navController: NavController) {
    Column {
        AppTopBar(title = stringResource(id = R.string.app_title))
        Spacer(modifier = Modifier.padding(dimensionResource(id = R.dimen.medium_padding)))
        GalleryScreen(viewModel = viewModel, navController = navController)
    }
}
@Composable
fun GalleryScreen(viewModel: PhotoViewModel, navController: NavController) {
    val photos = viewModel.photosLiveData.value

    LaunchedEffect(Unit) {
        viewModel.loadPhotos()
    }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier
            .fillMaxSize()
            .height(dimensionResource(id = R.dimen.big_height))
    ) {
        items(photos) { photo ->
            Photo(photo, viewModel, navController)
        }
    }
}

@Composable
fun Photo(photo: Photo, viewModel: PhotoViewModel, navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .aspectRatio(1f)
            .padding(dimensionResource(id = R.dimen.small_padding))
            .clip(MaterialTheme.shapes.medium)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current).data(data = photo.url)
                    .apply(block = fun ImageRequest.Builder.() {
                        crossfade(true)
                    }).build()
            ),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)
                .clickable(onClick = {
                    viewModel.changeSelectedPhoto(photo)
                    navController.navigate(PHOTO_SCREEN_ROUTE)
                }
                ),
            contentScale = ContentScale.Crop,
        )
    }
}
