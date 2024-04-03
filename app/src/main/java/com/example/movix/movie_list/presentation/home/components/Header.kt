package com.example.movix.movie_list.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.movix.R
import com.example.movix.ui.theme.Maastricht_Blue
import java.nio.file.WatchEvent

@Composable
fun Header(
    modifier: Modifier
){
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(.3f)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Box(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    top = 7.dp
                )
        ){
            Image(
                painterResource(id = R.drawable.movix_logo),
                contentDescription = "App Logo"
            )
        }
        Icon(
            modifier = Modifier
                .size(50.dp)
                .padding(
                    end = 20.dp,
                    top = 10.dp
                ),
            imageVector = Icons.Rounded.Search,
            contentDescription = "Search Icon"
        )
    }
}
