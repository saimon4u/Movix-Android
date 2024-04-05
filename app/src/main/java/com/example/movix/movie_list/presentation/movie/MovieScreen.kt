package com.example.movix.movie_list.presentation.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.movix.movie_list.presentation.home.HomeEvents
import com.example.movix.movie_list.presentation.home.HomeState
import com.example.movix.movie_list.presentation.movie.components.Item
import com.example.movix.movie_list.presentation.movie.components.TopSection

@Composable
fun MovieScreen(
    modifier: Modifier,
    homeState: HomeState,
    onEvent: (HomeEvents) -> Unit
){

    val configuration = LocalConfiguration.current

    val screenHeight = remember(configuration) {
        configuration.screenHeightDp.dp
    }
    val screenWidth = remember(configuration) {
        configuration.screenWidthDp.dp
    }

    Column(
        modifier = modifier.
        verticalScroll(rememberScrollState())
    ) {
        TopSection(
            modifier = Modifier.fillMaxWidth(),
            screenHeight = screenHeight,
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier
                .height(screenHeight)
                .width(screenWidth),
            contentPadding = PaddingValues(
                horizontal = (screenWidth*13)/100,
                vertical = 55.dp
            ),
            verticalArrangement = Arrangement.spacedBy(40.dp),
            horizontalArrangement = Arrangement.spacedBy(30.dp)
        ) {
            items(
                homeState.popularMovieList.size,
            ) { index ->
                Item(
                    imgPath = homeState.popularMovieList[index].poster_path,
                    title = homeState.popularMovieList[index].title,
                    date = homeState.popularMovieList[index].release_date,
                    percentage = homeState.popularMovieList[index].vote_average.toFloat()/10,
                    height = 250.dp,
                    width = 150.dp
                )
            }
        }
    }
}

