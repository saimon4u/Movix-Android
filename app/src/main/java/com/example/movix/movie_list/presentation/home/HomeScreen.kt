package com.example.movix.movie_list.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.movix.movie_list.presentation.home.components.Banner
import com.example.movix.movie_list.presentation.home.components.Header
import com.example.movix.ui.theme.Maastricht_Blue

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeState: HomeState
){
    Banner(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp),
        homeState = homeState
    )
}