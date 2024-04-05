package com.example.movix.movie_list.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Facebook
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.drawable.toDrawable
import com.example.movix.R
import com.example.movix.ui.theme.Blue_Charcoal

@Composable
fun AppInfo(
    modifier: Modifier
){
    Box(
        modifier = modifier
    ){
        Column(
            modifier = modifier
                .padding(10.dp),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp
                    ),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Terms Of Use",
                    color = Color.White,
                    fontSize = 10.sp
                )
                Text(
                    text = "Privacy Policy",
                    color = Color.White,
                    fontSize = 10.sp
                )
                Text(
                    text = "About",
                    color = Color.White,
                    fontSize = 10.sp
                )
                Text(
                    text = "FAQ",
                    color = Color.White,
                    fontSize = 10.sp
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            Text(
                modifier = Modifier
                    .padding(
                    horizontal = 15.dp
                ),
                text = "Movix is your ultimate companion for exploring and discovering a world of movies and TV shows right from your Android device. With a sleek and user-friendly interface, Movix offers a seamless browsing experience, providing you with comprehensive details, personalized recommendations, and convenient features to enhance your entertainment journey.",
                color = Color.Gray,
                fontSize = 12.sp
            )

            Spacer(modifier = Modifier.height(15.dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 15.dp
                    ),
                horizontalArrangement = Arrangement.SpaceEvenly
            ){
                Icon(
                    imageVector = Icons.Rounded.Facebook,
                    contentDescription = "Facebook Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp),
                )

                Icon(
                    painter = painterResource(id = R.drawable.instagram),
                    contentDescription = "Facebook Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp),
                )

                Icon(
                    painter = painterResource(id = R.drawable.linkedin),
                    contentDescription = "Facebook Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp),
                )

                Icon(
                    painter = painterResource(id = R.drawable.github),
                    contentDescription = "Facebook Icon",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp),
                )
            }
        }
    }
}

