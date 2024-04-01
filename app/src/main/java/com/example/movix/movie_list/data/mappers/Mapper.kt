package com.example.movix.movie_list.data.mappers

import com.example.movix.movie_list.data.remote.response.MovieDto
import com.example.movix.movie_list.data.remote.response.ShowDto
import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show


fun MovieDto.toMovie(
    type: String
): Movie {
    return Movie(
        backdrop_path = backdrop_path!!,
        original_language = original_language!!,
        overview = overview!!,
        poster_path = poster_path!!,
        release_date = release_date!!,
        title = title!!,
        vote_average = vote_average!!,
        popularity = popularity!!,
        vote_count = vote_count!!,
        video = video!!,
        id = id!!,
        adult = adult!!,
        original_title = original_title!!,
        type = type,
        genre_ids = genre_ids!!
    )
}

fun ShowDto.toShow(
    type: String
): Show {
    return Show(
        adult = adult!!,
        backdrop_path = backdrop_path!!,
        first_air_date = first_air_date!!,
        genre_ids = genre_ids!!,
        id = id!!,
        name = name!!,
        origin_country = origin_country!!,
        original_language = original_language!!,
        original_name = original_name!!,
        overview = overview!!,
        popularity = popularity!!,
        poster_path = poster_path!!,
        vote_average = vote_average!!,
        vote_count = vote_count!!,
        type = type
    )
}