package com.example.movix.movie_list.presentation.movie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movix.ui.theme.Blue_Charcoal

@Composable
fun TopSection(
    modifier: Modifier,
    screenHeight: Dp,
){

    var genreMenu by remember {
        mutableStateOf(false)
    }

    var sortMenu by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .padding(
                horizontal = 15.dp
            )
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Explore Movies",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Blue_Charcoal),
        ){
            Text(
                text = "Select Genres",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        genreMenu = true
                    }
                    .height(30.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Blue_Charcoal),
        ){
            Text(
                text = "Select Sort Option",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        genreMenu = true
                    }
                    .height(30.dp),
                textAlign = TextAlign.Center
            )
        }
    }

    DropdownMenu(
        expanded = genreMenu,
        onDismissRequest = { genreMenu = false },
        offset = DpOffset(100.dp, (-screenHeight))
    ) {
        DropdownMenuItem(
            text = {
                   Text(
                       text = "Popularity Ascending",
                       fontSize = 14.sp,
                       color = Color.White,
                   )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Popularity Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Rating Ascending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Rating Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Release Date Ascending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Release Date Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
                text = {
                    Text(
                        text = "Title Ascending",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                },
        onClick = { /*TODO*/ }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Title Ascending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = { /*TODO*/ }
        )
    }
}