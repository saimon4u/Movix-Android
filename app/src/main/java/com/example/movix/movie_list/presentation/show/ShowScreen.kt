package com.example.movix.movie_list.presentation.show

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.movix.movie_list.domain.util.Type
import com.example.movix.movie_list.presentation.show.components.Item
import com.example.movix.movie_list.presentation.show.components.TopSection

@Composable
fun ShowScreen(
    modifier: Modifier,
    navController: NavHostController
){

    val configuration = LocalConfiguration.current

    val screenHeight = remember(configuration) {
        configuration.screenHeightDp.dp
    }
    val screenWidth = remember(configuration) {
        configuration.screenWidthDp.dp
    }

    val showViewModel = hiltViewModel<ShowViewModel>()
    val showState = showViewModel.showState.collectAsState().value

    Column(
        modifier = modifier.
        verticalScroll(rememberScrollState())
    ) {
        TopSection(
            modifier = Modifier.fillMaxWidth(),
            screenHeight = screenHeight,
            onEvent = showViewModel::onEvent
        )
        if(showState.discoverShowList.isEmpty()){
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                CircularProgressIndicator()
            }
        }else{
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .height(screenHeight)
                    .width(screenWidth),
                contentPadding = PaddingValues(
                    horizontal = (screenWidth*13)/100,
                    vertical = 55.dp
                ),
                verticalArrangement = Arrangement.spacedBy(40.dp),
                horizontalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(
                    showState.discoverShowList.size,
                ) { index ->
                    Item(
                        imgPath = showState.discoverShowList[index].poster_path,
                        title = showState.discoverShowList[index].original_name,
                        date = showState.discoverShowList[index].first_air_date,
                        percentage = showState.discoverShowList[index].vote_average.toFloat()/10,
                        height = 250.dp,
                        width = 150.dp,
                        id = showState.discoverShowList[index].id,
                        navController = navController
                    )
                    if(index >= showState.discoverShowList.size-1 && !showState.isLoading){
                        showViewModel.onEvent(ShowEvents.Paginate(Type.DISCOVER))
                    }
                }
            }
        }
    }
}

