package com.example.movix.movie_list.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.movix.movie_list.domain.util.Type
import com.example.movix.movie_list.presentation.home.components.AppInfo
import com.example.movix.movie_list.presentation.home.components.Banner
import com.example.movix.movie_list.presentation.home.components.ItemList
import com.example.movix.ui.theme.Maastricht_Blue

@Composable
fun HomeScreen(
    modifier: Modifier,
    homeState: HomeState,
    homeViewModel: HomeViewModel,
    navController: NavHostController
){
    val scrollState = rememberScrollState()

    Column(
        modifier = modifier
            .verticalScroll(
                state = scrollState,
                enabled = true
            )
    ) {
        Banner(
            modifier = Modifier
                .fillMaxWidth()
                .height(350.dp)
                .background(Maastricht_Blue.copy(.4f)),
            homeState = homeState,
        )

        Spacer(modifier = Modifier.height(20.dp))


        ItemList(
            modifier = Modifier
                .height(300.dp)
                .width(200.dp),
            homeState = homeState,
            topic = Type.POPULAR,
            homeViewModel = homeViewModel,
            onEvent = homeViewModel::onEvent,
            navController = navController
        )

        Spacer(modifier = Modifier.height(20.dp))

        ItemList(
            modifier = Modifier
                .height(300.dp)
                .width(200.dp),
            homeState = homeState,
            topic = Type.TOP_RATED,
            homeViewModel = homeViewModel,
            onEvent = homeViewModel::onEvent,
            navController = navController
        )
        Spacer(modifier = Modifier.height(20.dp))

        AppInfo(
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth()
                .background(Maastricht_Blue)
        )
        
        Spacer(modifier = Modifier.height(80.dp))
    }
}