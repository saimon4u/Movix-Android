package com.example.movix.details.data.mappers

import com.example.movix.details.data.remote.response.credits.CastDto
import com.example.movix.details.data.remote.response.credits.CrewDto
import com.example.movix.details.data.remote.response.details.movie.MovieDetailsDto
import com.example.movix.details.data.remote.response.details.show.ShowDetailsDto
import com.example.movix.details.domain.model.Cast
import com.example.movix.details.domain.model.Crew
import com.example.movix.details.domain.model.MovieDetails
import com.example.movix.details.domain.model.ShowDetails


fun CrewDto.toCrew(): Crew {
    return Crew(
        adult = adult ?: false,
        credit_id = credit_id ?: "",
        department = department ?: "",
        gender = gender ?: -1,
        id = id ?: -1,
        job = job ?: "",
        known_for_department = known_for_department ?: "",
        name = name ?: "",
        original_name = original_name ?: "",
        popularity = popularity ?: 0.0,
        profile_path = profile_path ?: ""
    )
}


fun CastDto.toCast(): Cast {
    return Cast(
        adult = adult ?: false,
        credit_id = credit_id ?: "",
        gender = gender ?: -1,
        id = id ?: -1,
        known_for_department = known_for_department ?: "",
        name = name ?: "",
        original_name = original_name ?: "",
        popularity = popularity ?: 0.0,
        profile_path = profile_path ?: "",
        cast_id = cast_id ?: -1,
        character = character ?: "",
        order = order ?: -1
    )
}

fun MovieDetailsDto.toMovieDetails(): MovieDetails{
    return MovieDetails(
        backdrop_path = backdrop_path ?: "",
        budget = budget ?: -1,
        genres = genres?.map { genre->
            genre.id
        } ?: listOf(-1, -2),
        homepage = homepage ?: "",
        id = id ?: -1,
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        runtime = runtime ?: -1,
        tagline = tagline ?: "",
        title = title ?: "",
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: -1
    )
}

fun ShowDetailsDto.toShowDetails(): ShowDetails{
    return ShowDetails(
        backdrop_path = backdrop_path ?: "",
        episode_run_time = episode_run_time ?: listOf(-1,-2),
        first_air_date =first_air_date ?: "",
        genres = genres?.map {genre ->
            genre.id
        } ?: listOf(-1,-2),
        homepage = homepage ?: "",
        id = id ?: -1,
        name = name ?: "",
        number_of_episodes = number_of_episodes ?: -1,
        original_name = original_name ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        tagline = tagline ?: "",
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: -1
    )
}