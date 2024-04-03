package com.example.movix.movie_list.presentation.home

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.presentation.home.components.Banner
import com.example.movix.movie_list.presentation.home.components.CircularProgressBar
import com.example.movix.movie_list.presentation.home.components.Header
import com.example.movix.movie_list.presentation.home.components.ItemList
import com.example.movix.movie_list.presentation.home.components.ToggleBar
import com.example.movix.ui.theme.Maastricht_Blue

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeState: HomeState,
    homeViewModel: HomeViewModel
){
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(
                state = scrollState,
                enabled = true
            )
    ) {
        Banner(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(Maastricht_Blue.copy(.4f)),
            homeState = homeState
        )

        Spacer(modifier = Modifier.height(20.dp))


        ItemList(
            modifier = Modifier
                .height(300.dp)
                .width(200.dp),
            homeState = homeState,
            topic = "Popular",
            homeViewModel = homeViewModel
        )

        Spacer(modifier = Modifier.height(20.dp))

        ItemList(
            modifier = Modifier
                .height(300.dp)
                .width(200.dp),
            homeState = homeState,
            topic = "Rated",
            homeViewModel = homeViewModel
        )
        Spacer(modifier = Modifier.height(100.dp))
    }
}