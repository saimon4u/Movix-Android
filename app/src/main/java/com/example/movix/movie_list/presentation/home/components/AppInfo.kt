package com.example.movix.movie_list.presentation.home.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movix.R

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
                text = "Movix is your ultimate companion for exploring and discovering a world of movies and TV shows right from your Android device. With a sleek and user friendly interface, Movix offers a seamless browsing experience, providing you with comprehensive details, personalized recommendations, and convenient features to enhance your entertainment journey.",
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
                    id = R.drawable.facebook,
                    url = "https://facebook.com/SaimonBhuiyan4U",
                    desc = "Facebook Icon"
                )

                Icon(
                    id = R.drawable.instagram,
                    url = "https://www.instagram.com/_mahmudulsaimon4u_?igsh=aGtoanB1aWV1NXBt",
                    desc = "Instagram Icon"
                )

                Icon(
                    id = R.drawable.linkedin,
                    url = "https://www.linkedin.com/in/saimon-bhuiyan-7a26262a6",
                    desc = "Linkedin Icon"
                )

                Icon(
                    id = R.drawable.github,
                    url = "https://github.com/saimon4u",
                    desc = "Github Icon"
                )
            }
        }
    }
}