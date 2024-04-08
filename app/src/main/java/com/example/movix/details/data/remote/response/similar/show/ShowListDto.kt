package com.example.movix.details.data.remote.response.similar.show

data class ShowListDto(
    val page: Int,
    val results: List<ShowDto>,
    val total_pages: Int,
    val total_results: Int
)