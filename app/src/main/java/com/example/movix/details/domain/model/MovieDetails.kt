package com.example.movix.details.domain.model


data class MovieDetails(
    val backdrop_path: String,
    val budget: Int,
    val genres: List<Int>,
    val homepage: String,
    val id: Int,
    val original_title: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val release_date: String,
    val runtime: Int,
    val tagline: String,
    val title: String,
    val vote_average: Double,
    val vote_count: Int
)