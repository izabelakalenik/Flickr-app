package com.example.flickr_app.ui.screens

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import com.example.flickr_app.R
import com.example.flickr_app.ui.theme.DarkGrey
import com.example.flickr_app.ui.theme.LightGrey

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(title: String) {
    Surface(
        color = DarkGrey
    ){
        TopAppBar(
            modifier = Modifier
                .padding(dimensionResource(id = R.dimen.big_padding))
                .height(dimensionResource(id = R.dimen.top_bar_height)),
            title = {
                Text(
                    text = title,
                    fontWeight = FontWeight.Bold,
                    color = LightGrey,
                )
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = DarkGrey)
        )
    }
}