package com.example.movix.movie_list.presentation.movie

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movix.movie_list.domain.util.Type
import com.example.movix.movie_list.presentation.movie.components.Item
import com.example.movix.movie_list.presentation.movie.components.TopSection

@Composable
fun MovieScreen(
    modifier: Modifier,
    navController: NavHostController
){

    val configuration = LocalConfiguration.current

    val screenHeight = remember(configuration) {
        configuration.screenHeightDp.dp
    }
    val screenWidth = remember(configuration) {
        configuration.screenWidthDp.dp
    }

    val movieViewModel = hiltViewModel<MovieViewModel>()
    val movieState = movieViewModel.movieState.collectAsState().value

    Column(
        modifier = modifier.
        verticalScroll(rememberScrollState())
    ) {
        TopSection(
            modifier = Modifier.fillMaxWidth(),
            screenHeight = screenHeight,
            onEvent = movieViewModel::onEvent
        )
        if(movieState.discoverMovieList.isEmpty()){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator()
            }
        }else{
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
                    movieState.discoverMovieList.size,
                ) { index ->
                    Item(
                        imgPath = movieState.discoverMovieList[index].poster_path,
                        title = movieState.discoverMovieList[index].title,
                        date = movieState.discoverMovieList[index].release_date,
                        percentage = movieState.discoverMovieList[index].vote_average.toFloat()/10,
                        height = 250.dp,
                        width = 150.dp,
                        navController = navController,
                        id = movieState.discoverMovieList[index].id
                    )
                    if(index >= movieState.discoverMovieList.size-1 && !movieState.isLoading){
                        movieViewModel.onEvent(MovieEvents.Paginate(Type.DISCOVER))
                    }
                }
            }
        }
    }
}