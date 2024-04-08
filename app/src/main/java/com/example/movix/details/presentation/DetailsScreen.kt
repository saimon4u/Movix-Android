package com.example.movix.details.presentation

import android.util.Log
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircle
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movix.core.presentation.components.CircularProgressBar
import com.example.movix.details.presentation.components.CastHolder
import com.example.movix.details.presentation.components.GenreHolder
import com.example.movix.details.presentation.components.InfoItem
import com.example.movix.details.presentation.components.Overview
import com.example.movix.details.presentation.components.PosterSection
import com.example.movix.details.presentation.util.movieGenreMap
import com.example.movix.movie_list.domain.util.Category
import com.example.movix.ui.theme.Blue_Charcoal
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView

@Composable
fun DetailsScreen() {

    val detailsViewModel = hiltViewModel<DetailsViewModel>()
    val detailsState = detailsViewModel.detailsState.collectAsState().value
    var isDataAvailable by remember{
        mutableStateOf(false)
    }

//    val ctx = LocalContext.current
//    AndroidView(factory = {
//        var view = YouTubePlayerView(it)
//        val fragment = view.addYouTubePlayerListener(
//            object : AbstractYouTubePlayerListener() {
//                override fun onReady(youTubePlayer: YouTubePlayer) {
//                    super.onReady(youTubePlayer)
//                    youTubePlayer.loadVideo(videoId, 0f)
//                }
//            }
//        )
//        view
//    })
    val imgPath = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.poster_path else detailsState.showDetails?.poster_path
    val title = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.title else detailsState.showDetails?.name
    val tagline = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.tagline else detailsState.showDetails?.tagline
    val genreIds = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.genres else detailsState.showDetails?.genres
    val percentage = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.vote_average?.toFloat()?.div(10) else detailsState.showDetails?.vote_average?.toFloat()?.div(10)
    val overView = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.overview else detailsState.showDetails?.overview
    val voteCount = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.vote_count else detailsState.showDetails?.vote_count
    val releaseDate = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.release_date else detailsState.showDetails?.first_air_date
    var runTime = if(detailsState.category == Category.MOVIE) detailsState.movieDetails?.runtime else {
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

                Row (
                    modifier = Modifier
                        .padding(
                            horizontal = 20.dp
                        )
                ){
                    for(i in genreIds!!){
                        
                        GenreHolder(text = movieGenreMap[i] ?: "")
                        
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
                        modifier = Modifier.wrapContentSize()
                    ){
                        Icon(
                            modifier = Modifier
                                .size(70.dp)
                                .padding(bottom = 5.dp),
                            imageVector = Icons.Rounded.PlayCircle,
                            contentDescription = "Play Trailer",
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Text(
                            text = "Watch Trailer",
                            fontSize = 20.sp,
                            color = Color.White,
                            modifier = Modifier
                                .padding(top = 10.dp)
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

                
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
    }
}