package com.example.movix.movie_list.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movix.movie_list.domain.util.Category
import com.example.movix.movie_list.presentation.home.HomeEvents
import com.example.movix.movie_list.presentation.home.HomeState

@Composable
fun ToggleBar(
    onEvent: (HomeEvents) -> Unit,
    type: String,
    homeState: HomeState
){
    Row (
        modifier = Modifier
            .height(30.dp)
            .width(160.dp)
            .clip(RoundedCornerShape(20.dp))
            .background(Color.White),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        val moviesColor: Color = when(type){
            "Popular" -> if(homeState.isPopularMovie) Color.Green else Color.White
            "Rated" -> if(homeState.isRatedMovie) Color.Green else Color.White
            else -> {Color.White}
        }

        val showsColor: Color = when(type){
            "Popular" -> if(homeState.isPopularShow) Color.Green else Color.White
            "Rated" -> if(homeState.isRatedShow) Color.Green else Color.White
            else -> {Color.White}
        }

        Button(
            onClick = {
                      onEvent(HomeEvents.Toggle(
                          category = Category.MOVIE,
                          list = type
                      ))
            },
            modifier = Modifier
                .height(25.dp)
                .width(75.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = moviesColor
            )
        ) {
            Text(
                text = "Movies",
                color = Color.Black,
                fontSize = 6.sp,
                textAlign = TextAlign.Center
            )
        }

        Button(
            onClick = {
                onEvent(HomeEvents.Toggle(
                    category = Category.SHOW,
                    list = type
                ))
            },
            modifier = Modifier
                .height(25.dp)
                .width(75.dp)
                .clip(RoundedCornerShape(20.dp)),
            colors = ButtonDefaults.buttonColors(
                containerColor = showsColor
            )
        ) {
            Text(
                text = "Tv Show",
                color = Color.Black,
                fontSize = 6.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}