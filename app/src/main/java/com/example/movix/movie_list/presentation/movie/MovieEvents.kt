package com.example.movix.movie_list.presentation.movie

sealed class MovieEvents {
    data class Paginate(val type: String, val category: String): MovieEvents()
    object Navigate: MovieEvents()
    data class Select(val type: String, val category: String): MovieEvents()
    data class Toggle(val category: String, val list: String): MovieEvents()
}