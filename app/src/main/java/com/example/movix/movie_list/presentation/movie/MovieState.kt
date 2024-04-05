package com.example.movix.movie_list.presentation.movie

import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show
import com.example.movix.movie_list.presentation.movie.util.Genre
import com.example.movix.movie_list.presentation.movie.util.SortType

data class MovieState(
    val isLoading: Boolean = false,
    val discoverMoviePageNo: Int = 1,
    val isMovie: Boolean = true,
    val discoverMovieList: List<Movie> = emptyList(),
    val sortType: String = SortType.Popularity_Descending,
    val genreId: Int = Genre.HORROR
)