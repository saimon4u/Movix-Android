package com.example.movix.details.data.remote.response.details.show

data class ShowDetailsDto(
    val backdrop_path: String?,
    val episode_run_time: List<Int>?,
    val first_air_date: String?,
    val genres: List<Genre>?,
    val homepage: String?,
    val id: Int?,
    val name: String?,
    val number_of_episodes: Int?,
    val original_name: String?,
    val overview: String?,
    val popularity: Double?,
    val poster_path: String?,
    val tagline: String?,
    val vote_average: Double?,
    val vote_count: Int?
)