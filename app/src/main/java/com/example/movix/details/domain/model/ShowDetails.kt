package com.example.movix.details.domain.model


data class ShowDetails(
    val backdrop_path: String,
    val episode_run_time: List<Int>,
    val first_air_date: String,
    val genres: List<Int>,
    val homepage: String,
    val id: Int,
    val name: String,
    val number_of_episodes: Int,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val tagline: String,
    val vote_average: Double,
    val vote_count: Int
)