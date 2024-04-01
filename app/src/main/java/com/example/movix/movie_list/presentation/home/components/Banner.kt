package com.example.movix.movie_list.presentation.home.components

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movix.movie_list.data.remote.Api
import com.example.movix.movie_list.presentation.home.HomeState

@Composable
fun Banner(
    modifier: Modifier,
    homeState: HomeState
){
    var imgLink: String? = null
    if(homeState.popularMovieList.isNotEmpty()){
        imgLink = homeState.popularMovieList[(0 until homeState.popularMovieList.size).random()].backdrop_path
    }

    Box(
        modifier = modifier
    ){
        if(imgLink != null){
            val imgState = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(Api.BASE_IMG_URL + imgLink)
                    .size(Size.ORIGINAL)
                    .build()
            ).state
            if(imgState is AsyncImagePainter.State.Success){
                Image(
                    painter = imgState.painter,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .blur(15.dp),
                    contentDescription = "Background Image"
                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
        ) {

            Header(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Text(
                text = "Welcome",
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Millions of movies, TV shows and people to discover. Explore now.",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White,
                maxLines = 2
            )

        }
    }
}