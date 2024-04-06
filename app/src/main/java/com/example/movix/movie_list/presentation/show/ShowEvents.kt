package com.example.movix.movie_list.presentation.show

sealed class ShowEvents {
    data class Paginate(val type: String): ShowEvents()
    object Navigate: ShowEvents()
    data class SelectGenre(val genreId: Int): ShowEvents()
    data class Sort(val sortType: String): ShowEvents()
}