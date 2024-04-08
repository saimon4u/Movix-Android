package com.example.movix.details.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movix.R
import com.example.movix.details.data.remote.DetailsApi
import com.example.movix.details.domain.model.Cast

@Composable
fun CastHolder(
    cast: Cast
){
    val imgState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(DetailsApi.BASE_IMG_URL + cast.profile_path)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Column(
        modifier = Modifier
            .height(220.dp)
    ){
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
        ){
            Image(
                painter = if(imgState is AsyncImagePainter.State.Success) imgState.painter else painterResource(
                    id = R.drawable.no_poster
                ),
                contentDescription = cast.name,
                contentScale = ContentScale.FillBounds
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier
                .width(100.dp),
            text = cast.name,
            fontSize = 15.sp,
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2
        )

        Spacer(modifier = Modifier.height(5.dp))

        Text(
            modifier = Modifier
                .width(100.dp),
            text = cast.character,
            fontSize = 12.sp,
            color = Color.LightGray,
            maxLines = 2
        )
    }
}