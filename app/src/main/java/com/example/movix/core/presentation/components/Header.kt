package com.example.movix.core.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ImageNotSupported
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Sort
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movix.R
import com.example.movix.ui.theme.Maastricht_Blue
import java.nio.file.WatchEvent

@Composable
fun Header(
    modifier: Modifier,
    navHostController: NavHostController
){

    var expanded by remember { mutableStateOf(false) }
    var selectDD by remember{ mutableStateOf(false) }

    val configuration = LocalConfiguration.current

    val screenHeight = remember(configuration) {
        configuration.screenHeightDp.dp
    }

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
