package com.example.movix.movie_list.data.remote.response

data class ShowListDto(
    val page: Int,
    val results: List<ShowDto>,
    val total_pages: Int,
    val total_results: Int
)