package com.example.movix.movie_list.presentation.movie.components

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
import com.example.movix.movie_list.presentation.movie.MovieEvents
import com.example.movix.movie_list.presentation.movie.util.Genre
import com.example.movix.movie_list.presentation.movie.util.SortType
import com.example.movix.ui.theme.Blue_Charcoal

@Composable
fun TopSection(
    modifier: Modifier,
    screenHeight: Dp,
    onEvent: (MovieEvents) -> Unit
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
        mutableStateOf(Genre.HORROR)
    }

    Column(
        modifier = modifier
            .padding(
                horizontal = 15.dp
            )
    ) {
        Spacer(modifier = Modifier.height(70.dp))
        Text(
            text = "Explore Movies",
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
                text = "Select Genre",
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
                text = "Select Sorting Option",
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                sortOption = SortType.Title_Descending
                onEvent(MovieEvents.Sort(sortOption))
                sortMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "ADVENTURE",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.ADVENTURE
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "DRAMA",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.DRAMA
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
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
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "FANTASY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.FANTASY
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "HISTORY",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.HISTORY
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "HORROR",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.HORROR
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "ROMANCE",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.ROMANCE
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "SCIENCE_FICTION",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.SCIENCE_FICTION
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "THRILLER",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.THRILLER
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
        DropdownMenuItem(
            text = {
                Text(
                    text = "WESTERN",
                    fontSize = 14.sp,
                    color = Color.White,
                )
            },
            onClick = {
                genre = Genre.WESTERN
                onEvent(MovieEvents.SelectGenre(genre))
                genreMenu = false
            }
        )
    }


}

private val genreMap: Map<Int, String> = mapOf(
    28 to "Action",
    12 to "Adventure",
    16 to "Animation",
    35 to "Comedy",
    80 to "Crime",
    99 to "Documentary",
    18 to "Drama",
    10751 to "Family",
    14 to "Fantasy",
    36 to "History",
    27 to "Horror",
    10749 to "Romance",
    878 to "Science Fiction",
    53 to "Thriller",
    37 to "Western"
)


val sortingOptionsMap: Map<String, String> = mapOf(
    "popularity.desc" to "Popularity Descending",
    "popularity.asc" to "Popularity Ascending",
    "vote_average.asc" to "Rating Ascending",
    "vote_average.desc" to "Rating Descending",
    "primary_release_date.asc" to "Release Date Ascending",
    "primary_release_date.desc" to "Release Date Descending",
    "original_title.asc" to "Title Ascending",
    "original_title.desc" to "Title Descending"
)