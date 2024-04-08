package com.example.movix.details.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GenreHolder(
    text: String
){
    Box(modifier = Modifier
        .wrapContentSize()
        .clip(RoundedCornerShape(30.dp))
        .background(Color.Red)
        .padding(
            horizontal = 10.dp,
            vertical = 5.dp
        )
    ){
        Text(
            text = text,
            fontSize = 15.sp,
            color = Color.White
        )
    }
}