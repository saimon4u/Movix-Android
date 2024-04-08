package com.example.movix.movie_list.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.movix.movie_list.presentation.home.HomeScreen
import com.example.movix.movie_list.presentation.home.HomeViewModel
import com.example.movix.core.presentation.components.BottomNavigationBar
import com.example.movix.core.presentation.components.Header
import com.example.movix.details.presentation.DetailsScreen
import com.example.movix.movie_list.presentation.movie.MovieScreen
import com.example.movix.movie_list.presentation.show.ShowScreen
import com.example.movix.ui.theme.Maastricht_Blue
import com.example.movix.ui.theme.MovixTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MovixTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = hiltViewModel<HomeViewModel>()
                    val homeState = viewModel.homeState.collectAsState().value
                    val navController = rememberNavController()

                    Scaffold(
                        topBar = {
                            Header(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                navHostController = navController
                            )
                        },
                        bottomBar = {
                            BottomNavigationBar(
                                bottomNavController = navController,
                                onEvent = viewModel::onEvent
                            )
                        }
                    ) {
                        val padding = it
                        NavHost(
                            navController = navController,
                            startDestination = "Home"
                        ){
                            composable("Home"){
                                HomeScreen(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Maastricht_Blue),
                                    homeState = homeState,
                                    homeViewModel = viewModel,
                                    navController = navController
                                )
                            }
                            composable("Movie"){
                                MovieScreen(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Maastricht_Blue),
                                    navController = navController
                                )
                            }
                            composable("Show"){
                                ShowScreen(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Maastricht_Blue),
                                    navController = navController
                                )
                            }

                            composable(
                                route = "Details" + "/{category}" + "/{id}",
                                arguments = listOf(
                                    navArgument("category"){type = NavType.StringType},
                                    navArgument("id"){type = NavType.IntType}
                                )
                            ){
                                DetailsScreen(navController)
                            }
                        }
                    }
                }
            }
        }
    }
}
