package com.example.movix.details.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircleOutline
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movix.core.presentation.components.CircularProgressBar
import com.example.movix.details.presentation.components.CastHolder
import com.example.movix.details.presentation.components.GenreHolder
import com.example.movix.details.presentation.components.InfoItem
import com.example.movix.details.presentation.components.Overview
import com.example.movix.details.presentation.components.PosterSection
import com.example.movix.details.presentation.components.VideoHolder
import com.example.movix.details.presentation.components.YouTubeScreen
import com.example.movix.details.presentation.util.movieGenreMap
import com.example.movix.details.presentation.util.showGenreMap
import com.example.movix.movie_list.domain.util.Category
import com.example.movix.movie_list.presentation.home.components.AppInfo
import com.example.movix.movie_list.presentation.home.components.Item
import com.example.movix.ui.theme.Blue_Charcoal
import com.example.movix.ui.theme.Maastricht_Blue
@Composable
fun DetailsScreen(
    navController: NavHostController
) {

    val detailsViewModel = hiltViewModel<DetailsViewModel>()
    val detailsState = detailsViewModel.detailsState.collectAsState().value
    var isDataAvailable by remember{
        mutableStateOf(false)
    }

    val imgPath = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.poster_path else detailsState.showDetails?.poster_path
    val title = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.title else detailsState.showDetails?.name
    val tagline = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.tagline else detailsState.showDetails?.tagline
    val genreIds = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.genres else detailsState.showDetails?.genres
    val percentage = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.vote_average?.toFloat()?.div(10) else detailsState.showDetails?.vote_average?.toFloat()?.div(10)
    val overView = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.overview else detailsState.showDetails?.overview
    val voteCount = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.vote_count else detailsState.showDetails?.vote_count
    val releaseDate = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.release_date else detailsState.showDetails?.first_air_date
    val runTime = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.runtime else {
        var time: Int = 0
        for(i in detailsState.showDetails!!.episode_run_time){
            time += i
        }
        time /= detailsState.showDetails.number_of_episodes

        if(time == 0) time = detailsState.showDetails.number_of_episodes * 30
        time
    }
    var directorList: String = ""
    var writerList: String = ""
    for(crew in detailsState.crewList){
        if(crew.job == "Director"){
            directorList += crew.original_name + ", "
        }
        else if(crew.job == "ScreenPlay" || crew.job == "Story" || crew.job == "Writer" || crew.job == "Writing"){
            writerList += crew.original_name + ", "
        }
    }




    if(imgPath != null && title != null && tagline != null) isDataAvailable = true

    Box(
        modifier = Modifier
            .fillMaxSize()
    ){
        if(detailsState.isPlaying){
            YouTubeScreen(
                videoId = detailsState.videoList[0].key,
                onEvent = detailsViewModel::onEvent
            )
        }else{
            if(!isDataAvailable){
                Box(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
            }else{
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(rememberScrollState())
                ){
                    PosterSection(
                        modifier = Modifier
                            .height(600.dp)
                            .fillMaxWidth(),
                        imgPath = imgPath!!
                    )

                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp),
                        text = title!!,
                        fontSize = 25.sp,
                        color = Color.White,
                        maxLines = 2,
                        fontWeight = FontWeight.SemiBold
                    )

                    Spacer(modifier = Modifier.height(20.dp))


                    Text(
                        modifier = Modifier
                            .padding(start = 20.dp),
                        text = tagline!!,
                        fontSize = 15.sp,
                        color = Color.Gray,
                        maxLines = 1,
                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    LazyRow (
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp
                            )
                    ){
                        items(genreIds!!.size){index ->
                            GenreHolder(
                                text = if(detailsState.category == Category.MOVIE) movieGenreMap[genreIds[index]] ?: "" else showGenreMap[genreIds[index]] ?: ""
                            )

                            Spacer(modifier = Modifier.width(10.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Row (
                        modifier = Modifier
                            .padding(
                                horizontal = 20.dp
                            )
                    ){
                        CircularProgressBar(
                            percentage = percentage ?: 0.64f,
                            bgColor = Blue_Charcoal.copy(.6f),
                            textColor = Color.White,
                            radius = 35.dp,
                            textSize = 17.sp
                        )

                        Spacer(modifier = Modifier.width(25.dp))

                        Row(
                            modifier = Modifier
                                .wrapContentSize()
                                .clickable {
                                    detailsViewModel.onEvent(DetailsEvents.Play(detailsState.videoId))
                                }
                                .padding(
                                    top = 10.dp
                                )
                        ){
                            Icon(
                                modifier = Modifier
                                    .size(55.dp)
                                    .padding(bottom = 10.dp),
                                imageVector = Icons.Rounded.PlayCircleOutline,
                                contentDescription = "Play Trailer",
                            )

                            Spacer(modifier = Modifier.width(10.dp))

                            Text(
                                text = "Watch Trailer",
                                fontSize = 20.sp,
                                color = Color.White,
                                modifier = Modifier
                                    .padding(top = 5.dp)
                            )
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Overview(overView = overView ?: "")

                    Spacer(modifier = Modifier.height(35.dp))

                    Row(
                        modifier = Modifier
                            .padding(horizontal = 20.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        InfoItem(heading = "Vote Count: ", body = voteCount.toString())

                        InfoItem(heading = "Release Date: ", body = releaseDate ?: "")

                        InfoItem(heading = "Runtime(Min): ", body = runTime.toString())
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .padding(horizontal = 20.dp)
                            .background(Color.LightGray)
                            .alpha(.3f)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ){
                        Text(
                            text = "Director: ",
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = if(directorList.isEmpty()) "null" else directorList.substring(0, directorList.length-2),
                            fontSize = 13.sp,
                            color = Color.LightGray
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .padding(horizontal = 20.dp)
                            .background(Color.LightGray)
                            .alpha(.3f)
                    )

                    Spacer(modifier = Modifier.height(15.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                    ){
                        Text(
                            text = "Writers: ",
                            fontSize = 15.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 5.dp),
                            text = if(writerList.isEmpty()) "null" else writerList.substring(0, writerList.length - 2),
                            fontSize = 13.sp,
                            color = Color.LightGray
                        )
                    }

                    Spacer(modifier = Modifier.height(15.dp))

                    Spacer(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(2.dp)
                            .padding(horizontal = 20.dp)
                            .background(Color.LightGray)
                            .alpha(.3f)
                    )

                    Spacer(modifier = Modifier.height(30.dp))



                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        text = "Casts:",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ){
                        items(detailsState.castList.size){index ->
                            CastHolder(cast = detailsState.castList[index])
                            Spacer(modifier = Modifier.width(15.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        text = "Top Videos:",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))


                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ){
                        items(detailsState.videoList.size){index ->
                            VideoHolder(
                                video = detailsState.videoList[index],
                                onEvent = detailsViewModel::onEvent
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(30.dp))

                    Text(
                        modifier = Modifier
                            .padding(horizontal = 20.dp),
                        text = if(detailsState.category == Category.MOVIE) "Similar Movies: " else "Similar Shows: ",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    Spacer(modifier = Modifier.height(10.dp))

                    LazyRow(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp)
                    ){
                        items(if(detailsState.category == Category.MOVIE) detailsState.similarMovies.size else detailsState.similarShows.size){index ->
                            Item(
                                imgPath = if(detailsState.category == Category.MOVIE) detailsState.similarMovies[index].poster_path else detailsState.similarShows[index].poster_path,
                                title = if(detailsState.category == Category.MOVIE) detailsState.similarMovies[index].title else detailsState.similarShows[index].name,
                                date = if(detailsState.category == Category.MOVIE) detailsState.similarMovies[index].release_date else detailsState.similarShows[index].first_air_date,
                                percentage = if(detailsState.category == Category.MOVIE) detailsState.similarMovies[index].vote_average.toFloat().div(10) else detailsState.similarShows[index].vote_average.toFloat().div(10),
                                id = if(detailsState.category == Category.MOVIE) detailsState.similarMovies[index].id else detailsState.similarShows[index].id,
                                navController = navController,
                                category = if(detailsState.category == Category.MOVIE) Category.MOVIE else Category.SHOW
                            )
                            Spacer(modifier = Modifier.width(15.dp))
                        }
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    AppInfo(
                        modifier = Modifier
                            .height(300.dp)
                            .fillMaxWidth()
                            .background(Maastricht_Blue)
                    )


                    Spacer(modifier = Modifier.height(100.dp))
                }
            }
        }
    }
}