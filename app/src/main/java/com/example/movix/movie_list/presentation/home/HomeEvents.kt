package com.example.movix.movie_list.presentation.home

sealed class HomeEvents {
    data class Paginate(val type: String, val category: String): HomeEvents()
    object Navigate: HomeEvents()
    data class Select(val type: String, val category: String): HomeEvents()
    data class Toggle(val category: String, val list: String): HomeEvents()
}