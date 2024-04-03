package com.example.movix.movie_list.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShowEntity(
    val adult: Boolean,
    val backdrop_path: String,
    val first_air_date: String,
    val genre_ids: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val origin_country: String,
    val original_language: String,
    val original_name: String,
    val overview: String,
    val popularity: Double,
    val poster_path: String,
    val vote_average: Double,
    val vote_count: Int,
    val type: String
)