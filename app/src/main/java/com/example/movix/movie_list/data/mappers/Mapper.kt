package com.example.movix.movie_list.data.mappers

import com.example.movix.movie_list.data.local.MovieEntity
import com.example.movix.movie_list.data.local.ShowEntity
import com.example.movix.movie_list.data.remote.response.MovieDto
import com.example.movix.movie_list.data.remote.response.ShowDto
import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show


fun MovieDto.toMovieEntity(
    type: String
): MovieEntity{
    return MovieEntity(
        adult =  adult ?: false,
        backdrop_path = backdrop_path ?: "",
        original_language = original_language ?: "",
        overview = overview ?: "",
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        title = title ?: "",
        vote_average = vote_average ?: 0.0,
        popularity = popularity ?: 0.0,
        vote_count = vote_count ?: 0,
        id = id ?: -1,
        original_title = original_title ?: "",
        video = video ?: false,
        type = type,
        genre_ids = try {
            genre_ids?.joinToString(",") ?: "-1,-2"
        }catch (e: Exception){
            "-1,-2"
        }
    )
}

fun ShowDto.toShowEntity(
    type: String
): ShowEntity {
    return ShowEntity(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        first_air_date = first_air_date ?: "",
        id = id ?: -1,
        name = name ?: "",
        origin_country = try {
            origin_country?.joinToString(",") ?: "bd,usa"
        }catch (e: Exception){
            "bd,usa"
        },
        original_language = original_language ?: "",
        original_name = original_name ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: -1,
        type = type,
        genre_ids = try {
            genre_ids?.joinToString(",") ?: "-1,-2"
        }catch (e: Exception){
            "-1,-2"
        }
    )
}

fun ShowEntity.toShow(
    type: String
): Show{
    return Show(
        adult = adult,
        backdrop_path = backdrop_path,
        first_air_date = first_air_date,
        id = id,
        name = name,
        origin_country = try{
            origin_country.split(",")
        }catch (e: Exception){
            listOf("bd", "usa")
        },
        original_language = original_language,
        original_name = original_name,
        overview = overview,
        popularity = popularity,
        poster_path = poster_path,
        vote_average = vote_average,
        vote_count = vote_count,
        type = type,
        genre_ids = try{
            genre_ids.split(",").map { it.toInt() }
        }catch (e: Exception){
            listOf(-1, -2)
        }
    )
}

fun MovieEntity.toMovie(
    type: String
): Movie{
    return Movie(
        backdrop_path = backdrop_path,
        original_language = original_language,
        overview = overview,
        poster_path = poster_path,
        release_date = release_date,
        title = title,
        vote_average = vote_average,
        popularity = popularity,
        vote_count = vote_count,
        video = video,
        id = id,
        adult = adult,
        original_title = original_title,
        type = type,
        genre_ids = try{
            genre_ids.split(",").map { it.toInt() }
        }catch (e: Exception){
            listOf(-1, -2)
        }
    )
}