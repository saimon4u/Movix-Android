package com.example.movix.movie_list.presentation.show.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.movix.movie_list.presentation.show.util.Genre
import com.example.movix.core.util.SortType
import com.example.movix.movie_list.presentation.show.ShowEvents
import com.example.movix.ui.theme.Blue_Charcoal

@Composable
fun TopSection(
    modifier: Modifier,
    screenHeight: Dp,
    onEvent: (ShowEvents) -> Unit
){

    var genreMenu by remember {
        mutableStateOf(false)
    }

    var sortMenu by remember {
        mutableStateOf(false)
    }

    var sortOption by remember {
        mutableStateOf(SortType.Popularity_Descending)
    }

    var genre by remember {
        mutableIntStateOf(Genre.SCI_FI)
    }

    var isGenreSelected by remember{
        mutableStateOf(false)
    }
    var isSortSelected by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .padding(
                horizontal = 15.dp
            )
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Explore TV Shows",
            color = Color.White,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(15.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Blue_Charcoal),
        ){
            Text(
                text = if(isGenreSelected) genreMap[genre]!! else "Select Genre",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        genreMenu = true
                    }
                    .height(30.dp),
                textAlign = TextAlign.Center
            )
        }
        Spacer(modifier = Modifier.height(10.dp))

        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
                .background(Blue_Charcoal),
        ){
            Text(
                text = if(isSortSelected) sortingOptionsMap[sortOption]!! else "Select Sorting Option",
                fontSize = 18.sp,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        sortMenu = true
                    }
                    .height(30.dp),
                textAlign = TextAlign.Center
            )
        }
    }

    DropdownMenu(
        expanded = sortMenu,
        onDismissRequest = { sortMenu = false },
        offset = DpOffset(100.dp, (-screenHeight))
    ) {
        DropdownMenuItem(
            text = {
                   Text(
                       text = "Popularity Ascending",
                       fontSize = 14.sp,
                       color = Color.White,
                   )
            },
            onClick = {
                sortOption = SortType.Popularity_Ascending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Popularity Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Popularity_Descending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Rating Ascending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Rating_Ascending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Rating Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Rating_Descending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Release Date Ascending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Release_Date_Ascending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Release Date Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Release_Date_Descending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
                text = {
                    Text(
                        text = "Title Ascending",
                        fontSize = 14.sp,
                        color = Color.White,
                    )
                },
            onClick = {
                sortOption = SortType.Title_Ascending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "Title Descending",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                sortOption = SortType.Title_Descending
                onEvent(ShowEvents.Sort(sortOption))
                sortMenu = false
                isSortSelected = true
            }
        )
    }




    DropdownMenu(
        expanded = genreMenu,
        onDismissRequest = { genreMenu = false },
        offset = DpOffset(100.dp, (-screenHeight))
    ) {
        DropdownMenuItem(
            text = {
                Text(
                    text = "ACTION",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.ACTION
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "ANIMATION",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.ANIMATION
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "COMEDY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.COMEDY
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "CRIME",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.CRIME
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "DOCUMENTARY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.DOCUMENTARY
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "FAMILY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.FAMILY
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "KIDS",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.KIDS
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "MYSTERY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.MYSTERY
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "SCI-FI",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.SCI_FI
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "POLITICS",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.POLITICS
                onEvent(ShowEvents.SelectGenre(genre))
                genreMenu = false
                isGenreSelected = true
            }
        )
    }


}

private val genreMap: Map<Int, String> = mapOf(
    10759 to "Action & Adventure",
    16 to "Animation",
    35 to "Comedy",
    80 to "Crime",
    99 to "Documentary",
    10751 to "Family",
    10762 to "Kids",
    9648 to "Mystery",
    10765 to "Sci-Fi & Fantasy",
    10768 to "War & Politics"
)


private val sortingOptionsMap: Map<String, String> = mapOf(
    "popularity.desc" to "Popularity Descending",
    "popularity.asc" to "Popularity Ascending",
    "vote_average.asc" to "Rating Ascending",
    "vote_average.desc" to "Rating Descending",
    "primary_release_date.asc" to "Release Date Ascending",
    "primary_release_date.desc" to "Release Date Descending",
    "original_title.asc" to "Title Ascending",
    "original_title.desc" to "Title Descending"
)