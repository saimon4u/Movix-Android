package com.example.movix.movie_list.presentation.home.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    percentage: Float,
    radius: Dp = 20.dp,
) {
    Box(modifier = Modifier
        .size(radius * 2)
        .aspectRatio(1f)
        .background(Color.White, shape = CircleShape)
        .padding(5.dp),
        contentAlignment = Alignment.Center,
    ) {

        val color: Color = if(percentage * 10 > 7.5f) Color.Green else if(percentage * 10 > 5.5) Color.Yellow else Color.Red
        Canvas(modifier = Modifier.size(radius * 2)){
            drawArc(
                color = color,
                startAngle = -90f,
                sweepAngle = 360 * percentage,
                useCenter = false,
                style = Stroke(
                    4.dp.toPx(),
                    cap = StrokeCap.Round,
                ),
            )
        }
        Text(
            text = (percentage * 10).toString().substring(0,3),
            color = Color.Black,
            fontWeight = FontWeight.SemiBold,
            fontSize = 10.sp
        )
    }
}