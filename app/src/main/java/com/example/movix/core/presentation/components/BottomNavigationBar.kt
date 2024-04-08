package com.example.movix.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Movie
import androidx.compose.material.icons.rounded.Tv
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.movix.movie_list.presentation.home.HomeEvents
import com.example.movix.ui.theme.Maastricht_Blue

@Composable
fun BottomNavigationBar(
    bottomNavController: NavHostController,
    onEvent: (HomeEvents) -> Unit
){
    val items = listOf(
        BottomItem(
            title = "Home",
            icon = Icons.Rounded.Home
        ),
        BottomItem(
            title = "Movie",
            icon = Icons.Rounded.Movie
        ),
        BottomItem(
            title = "Tv Show",
            icon = Icons.Rounded.Tv
        ),
    )

    val selected = rememberSaveable{
        mutableIntStateOf(0)
    }

    NavigationBar {
        Row(
            modifier = Modifier
                .background(Maastricht_Blue.copy(.7f))
                .height(70.dp)
        ){
            items.forEachIndexed{index, bottomItem ->
                NavigationBarItem(
                    selected = selected.intValue == index,
                    onClick = {
                        selected.intValue = index
                        when(selected.intValue){
                            0->{
                                onEvent(HomeEvents.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate("Home")
                            }
                            1->{
                                onEvent(HomeEvents.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate("Movie")
                            }
                            2->{
                                onEvent(HomeEvents.Navigate)
                                bottomNavController.popBackStack()
                                bottomNavController.navigate("Show")
                            }

                        }
                    },
                    icon = {
                        Icon(
                            imageVector = bottomItem.icon,
                            contentDescription = bottomItem.title,
                            tint = MaterialTheme.colorScheme.onBackground
                        )
                    },
                    label = {
                        Text(
                            text = bottomItem.title,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    }
                )
            }
        }
    }
}

data class BottomItem(
    val title: String,
    val icon: ImageVector
)