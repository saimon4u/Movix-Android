package com.example.movix.movie_list.presentation.movie

import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show

data class MovieState(
    val isLoading: Boolean = false,
    val discoverMoviePageNo: Int = 1,
    val isMovie: Boolean = true,
    val discoverMovieList: List<Movie> = emptyList(),
)