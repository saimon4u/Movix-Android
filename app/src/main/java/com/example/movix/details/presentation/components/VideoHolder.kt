package com.example.movix.details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.PlayCircleOutline
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movix.R
import com.example.movix.details.data.remote.DetailsApi
import com.example.movix.details.domain.model.Video
import com.example.movix.details.presentation.DetailsEvents

@Composable
fun VideoHolder(
    video: Video,
    onEvent: (DetailsEvents) -> Unit
){
    val imgState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(DetailsApi.BASE_THUMBNAIL_URL_PREFIX + video.key + DetailsApi.BASE_THUMBNAIL_URL_SUFFIX)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column {
        Box(
            modifier = Modifier
                .height(120.dp)
                .width(200.dp)
                .clickable {
                      onEvent(DetailsEvents.Play(video.key))
                },
            contentAlignment = Alignment.Center
        ){
            Image(
                modifier = Modifier
                    .height(120.dp)
                    .width(200.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = if(imgState is AsyncImagePainter.State.Success) imgState.painter else painterResource(
                    id = R.drawable.no_poster
                ),
                contentDescription = "Video Thumbnail",
                contentScale = ContentScale.FillBounds
            )

            Icon(
                modifier = Modifier
                    .size(60.dp),
                imageVector = Icons.Rounded.PlayCircleOutline,
                contentDescription = "Play Button",
                tint = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier.
                width(180.dp)
                .padding(start = 10.dp),
            text = video.name,
            fontSize = 13.sp,
            color = Color.White,
            maxLines = 2
        )
    }
}