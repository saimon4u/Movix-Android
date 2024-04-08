package com.example.movix.core.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun CircularProgressBar(
    percentage: Float,
    radius: Dp = 20.dp,
    bgColor: Color,
    textColor: Color,
    textSize: TextUnit
) {

    Box(modifier = Modifier
        .size(radius * 2)
        .aspectRatio(1f)
        .background(bgColor, shape = CircleShape)
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
            color = textColor,
            fontWeight = FontWeight.Bold,
            fontSize = textSize
        )
    }
}