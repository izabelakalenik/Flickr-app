import com.example.flickr_app.api.ApiService
import com.example.flickr_app.data_classes.PhotoResponse
import com.example.flickr_app.data_classes.PhotoMetaData
import com.example.flickr_app.data_classes.PhotoSearchResponse
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.`when`

class ApiServiceTest {
    private lateinit var apiService: ApiService

    private fun createSamplePhotosSearchResponse(): PhotoSearchResponse {
        return PhotoSearchResponse(
            photos = PhotoMetaData(
                page = 1,
                photo = listOf(
                    PhotoResponse(
                        id = "0001",
                        owner = "owner_1",
                        secret = "secret_1",
                        server = "server_1",
                        farm = 1,
                        title = "First Photo",
                        datetaken = "2022-07-05",
                        ownername = "First Owner",
                        tags = "tag_1,tag_2",
                        views = "58"
                    ),
                    PhotoResponse(
                        id = "0002",
                        owner = "owner_2",
                        secret = "secret_2",
                        server = "server_2",
                        farm = 2,
                        title = "Second Photo",
                        datetaken = "2023-04-12",
                        ownername = "Second Owner",
                        tags = "tag_3,tag_4",
                        views = "403"
                    )
                )
            )
        )
    }

    @Before
    fun setUp() {
        apiService = mock(ApiService::class.java)
    }

    @Test
    fun fetchPhotosSearchResponse_returnsResponse() = runBlocking {
        `when`(apiService.fetchImages()).thenReturn(createSamplePhotosSearchResponse())
        val response = apiService.fetchImages()
        assertNotNull(response)
        assertTrue("Response should be of PhotosSearchResponse type", true)
        assertEquals("Page should match", 1, response.photos.page)
        assertEquals("Number of photos should match", 2, response.photos.photo.size)
        assertEquals("First photo owner should match", "owner_1", response.photos.photo[0].owner)
        assertEquals("Second photo farm should match", 2, response.photos.photo[1].farm)
    }
}