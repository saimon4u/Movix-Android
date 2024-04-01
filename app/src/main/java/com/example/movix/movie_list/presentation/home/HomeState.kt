package com.example.movix.movie_list.presentation.home

import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show

data class HomeState(
    val isLoading: Boolean = false,
    val popularMovieListPageNo: Int = 1,
    val popularShowListPageNo: Int = 1,
    val ratedMovieListPageNo:  Int = 1,
    val ratedShowListPageNo:  Int = 1,
    val isHome: Boolean = true,
    val popularMovieList: List<Movie> = emptyList(),
    val popularShowList: List<Show> = emptyList(),
    val ratedMovieList: List<Movie> = emptyList(),
    val ratedShowList: List<Show> = emptyList()
)