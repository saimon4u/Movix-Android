package com.example.movix.movie_list.presentation.home.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show
import com.example.movix.movie_list.presentation.home.HomeState
import com.example.movix.movie_list.presentation.home.HomeViewModel

@Composable
fun ItemList(
    modifier: Modifier,
    homeState: HomeState,
    topic: String,
    homeViewModel: HomeViewModel
//    onEvent: (HomeEvents) -> Unit
) {

    when(topic){
        "Popular" ->{
            if(homeState.isPopularMovie){
                LoadMovies(
                    modifier = modifier,
                    list = homeState.popularMovieList,
                    topic = topic,
                    homeViewModel = homeViewModel,
                    homeState = homeState
                )
            }else{
                LoadShows(
                    modifier = modifier,
                    list = homeState.popularShowList,
                    topic = topic,
                    homeViewModel = homeViewModel,
                    homeState = homeState
                )
            }
        }
        "Rated" ->{
            if(homeState.isRatedMovie){
                LoadMovies(
                    modifier = modifier,
                    list = homeState.ratedMovieList,
                    topic = topic,
                    homeViewModel = homeViewModel,
                    homeState = homeState
                )
            }else{
                LoadShows(
                    modifier = modifier,
                    list = homeState.ratedShowList,
                    topic = topic,
                    homeViewModel = homeViewModel,
                    homeState = homeState
                )
            }
        }
    }

}

@Composable
fun LoadMovies(
    modifier: Modifier,
    list: List<Movie>,
    topic: String,
    homeViewModel: HomeViewModel,
    homeState: HomeState
){
    if (list.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = topic,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            ToggleBar(
                type = topic,
                onEvent = homeViewModel::onEvent,
                homeState = homeState,
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                vertical = 15.dp,
                horizontal = 15.dp
            )
        ) {
            items(
                list.size,
            ){index ->
                Item(
                    imgPath = list[index].backdrop_path,
                    title = list[index].title,
                    date = list[index].release_date,
                    percentage = list[index].vote_average.toFloat()/10
                )
                Spacer(modifier = Modifier.width(15.dp))
//                if (index >= movieState.popularMovieList.size - 1 && !movieState.isLoading){
//                    onEvent(MovieUiEvents.Paginate(Category.POPULAR))
//                }
            }
        }
    }
}

@Composable
fun LoadShows(
    modifier: Modifier,
    list: List<Show>,
    topic: String,
    homeViewModel: HomeViewModel,
    homeState: HomeState
    ){
    if (list.isEmpty()) {
        Box(
            modifier = modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    } else {
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 15.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween
        ){
            Text(
                text = topic,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
            ToggleBar(
                type = topic,
                onEvent = homeViewModel::onEvent,
                homeState = homeState
            )
        }
        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            contentPadding = PaddingValues(
                vertical = 15.dp,
                horizontal = 15.dp
            )
        ) {
            items(
                list.size,
            ){index ->
                Item(
                    imgPath = list[index].backdrop_path,
                    title = list[index].name,
                    date = list[index].first_air_date,
                    percentage = list[index].vote_average.toFloat()/10
                )
                Spacer(modifier = Modifier.width(15.dp))
//                if (index >= movieState.popularMovieList.size - 1 && !movieState.isLoading){
//                    onEvent(MovieUiEvents.Paginate(Category.POPULAR))
//                }
            }
        }
    }
}