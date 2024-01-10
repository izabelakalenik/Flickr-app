package com.example.flickr_app.main_logic

import MainScreen
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.flickr_app.ui.screens.PhotoScreen

const val MAIN_SCREEN_ROUTE = "main_screen"
const val PHOTO_SCREEN_ROUTE = "photo_screen"

@Composable
fun Navigation(photoViewModel: PhotoViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = MAIN_SCREEN_ROUTE
    ) {
        composable(MAIN_SCREEN_ROUTE) {
            MainScreen(navController = navController, viewModel = photoViewModel)
        }

        composable(
            route = PHOTO_SCREEN_ROUTE,
        ) {
            PhotoScreen(viewModel = photoViewModel)
        }
    }
}