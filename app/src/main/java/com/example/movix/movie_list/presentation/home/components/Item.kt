package com.example.movix.movie_list.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import com.example.movix.R
import com.example.movix.core.presentation.components.CircularProgressBar
import com.example.movix.movie_list.data.remote.Api

@Composable
fun Item(
    imgPath: String,
    title: String,
    date: String,
    percentage: Float,
    id: Int,
    navController: NavHostController,
    category: String
){
    val imgState = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .data(Api.BASE_IMG_URL + imgPath)
            .size(Size.ORIGINAL)
            .build()
    ).state

    Box(
        modifier = Modifier
            .height(220.dp)
            .width(120.dp)
            .clickable {
                navController.navigate("Details" + "/${category}" + "/${id}")
            }
    ){
        Column(
            modifier = Modifier
                .height(150.dp)
                .width(120.dp)
                .clip(RoundedCornerShape(15.dp))
        ) {
            if(imgState is AsyncImagePainter.State.Error){
                Box(
                    modifier = Modifier
                        .height(150.dp)
                        .width(120.dp),
                    contentAlignment = Alignment.Center
                ){
                    Image(
                        modifier = Modifier
                            .height(150.dp)
                            .width(120.dp),
                        painter = painterResource(
                            id = R.drawable.no_poster
                        ),
                        contentDescription = "No Poster Found",
                        contentScale = ContentScale.FillBounds
                    )
                }
            }
            if(imgState is AsyncImagePainter.State.Success){
                Image(
                    modifier = Modifier
                        .height(150.dp)
                        .width(120.dp),
                    painter = imgState.painter,
                    contentDescription = title,
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Box (
            modifier = Modifier
                .padding(
                    top = 130.dp,
                    start = 10.dp
                )
        ){
            CircularProgressBar(percentage = percentage, bgColor = Color.White, textColor = Color.Black, textSize = 10.sp)
        }

        Text(
            modifier = Modifier
                .padding(
                    top = 175.dp,
                )
                .width(120.dp),
            text = title,
            textAlign = TextAlign.Center,
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            modifier = Modifier
                .padding(
                    top = 198.dp,
                )
                .width(120.dp),
            text = date,
            textAlign = TextAlign.Center,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}