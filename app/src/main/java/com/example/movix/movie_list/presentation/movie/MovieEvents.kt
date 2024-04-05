package com.example.movix.movie_list.presentation.movie

sealed class MovieEvents {
    data class Paginate(val type: String): MovieEvents()
    object Navigate: MovieEvents()
    data class SelectGenre(val genreId: Int): MovieEvents()
    data class Sort(val sortType: String): MovieEvents()
}