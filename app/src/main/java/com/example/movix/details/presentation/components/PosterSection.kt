package com.example.movix.details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movix.R
import com.example.movix.details.data.remote.DetailsApi

@Composable
fun PosterSection(
    modifier: Modifier,
    imgPath: String
){
    val imgState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(DetailsApi.BASE_IMG_URL + imgPath)
            .size(Size.ORIGINAL)
            .build()
    ).state


    Box(
        modifier = modifier
            .fillMaxSize()
    ){
        if(imgState is AsyncImagePainter.State.Success){
            Image(
                modifier = modifier
                    .fillMaxSize()
                    .alpha(.2f),
                painter = imgState.painter,
                contentDescription = null,
                contentScale = ContentScale.FillBounds
            )
        }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(20.dp)
                .clip(RoundedCornerShape(20.dp))
        ){
            if(imgState is AsyncImagePainter.State.Success){
                Image(
                    modifier = modifier
                        .fillMaxSize(),
                    painter = imgState.painter,
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
            if(imgState is AsyncImagePainter.State.Error){
                Image(
                    modifier = modifier
                        .fillMaxSize(),
                    painter = painterResource(id = R.drawable.no_poster),
                    contentDescription = null,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
    }
}