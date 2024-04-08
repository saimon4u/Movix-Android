package com.example.movix.movie_list.presentation.home.components

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun Icon(
    id: Int,
    url: String,
    desc: String
) {
    val context = LocalContext.current

    androidx.compose.material3.Icon(
        painter = painterResource(id = id),
        contentDescription = desc,
        tint = Color.White,
        modifier = Modifier
            .size(30.dp)
            .clickable {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }
    )
}