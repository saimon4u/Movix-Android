package com.example.movix.movie_list.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.movix.movie_list.presentation.home.HomeScreen
import com.example.movix.movie_list.presentation.home.HomeViewModel
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
                    HomeScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .background(Maastricht_Blue),
                        homeState = homeState
                    )
                }
            }
        }
    }
}
