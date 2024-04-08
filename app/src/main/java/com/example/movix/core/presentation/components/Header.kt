package com.example.movix.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movix.R

@Composable
fun Header(
    modifier: Modifier,
    navHostController: NavHostController
){
    Row(
        modifier = modifier
            .fillMaxSize()
            .background(Color.Black.copy(.3f)),
        horizontalArrangement = Arrangement.SpaceBetween,
    ){
        Box(
            modifier = Modifier
                .padding(
                    start = 15.dp,
                    top = 7.dp
                )
        ){
            Image(
                painterResource(id = R.drawable.movix_logo),
                contentDescription = "App Logo"
            )
        }
        if(navHostController.currentDestination?.route == "Home"){
            Icon(
                modifier = Modifier
                    .size(50.dp)
                    .padding(
                        end = 20.dp,
                        top = 10.dp
                    ),
                imageVector = Icons.Rounded.Search,
                contentDescription = "Search Icon"
            )
        }
    }
}
