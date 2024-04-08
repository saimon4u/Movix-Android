package com.example.movix.details.data.mappers

import com.example.movix.details.data.remote.response.credits.CastDto
import com.example.movix.details.data.remote.response.credits.CrewDto
import com.example.movix.details.data.remote.response.details.movie.MovieDetailsDto
import com.example.movix.details.data.remote.response.details.show.ShowDetailsDto
import com.example.movix.details.data.remote.response.videos.VideoDto
import com.example.movix.details.domain.model.Cast
import com.example.movix.details.domain.model.Crew
import com.example.movix.details.domain.model.MovieDetails
import com.example.movix.details.domain.model.ShowDetails
import com.example.movix.details.domain.model.SimilarMovie
import com.example.movix.details.domain.model.SimilarShow
import com.example.movix.details.domain.model.Video
import com.example.movix.details.data.remote.response.similar.movie.MovieDto
import com.example.movix.details.data.remote.response.similar.show.ShowDto


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


fun VideoDto.toVideo(): Video{
    return Video(
        id = id ?: "",
        iso_3166_1 = iso_3166_1 ?: "",
        iso_639_1 = iso_639_1 ?: "",
        key = key ?: "",
        name = name ?: "",
        official = official ?: false,
        published_at = published_at ?: "",
        site = site ?: "",
        size = size ?: -1,
        type = type ?: ""
    )
}

fun MovieDto.toSimilarMovie(): SimilarMovie{
    return SimilarMovie(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        genre_ids = genre_ids ?: listOf(-1, -2),
        id = id ?: -1,
        original_language = original_language ?: "",
        original_title = original_title ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        release_date = release_date ?: "",
        title = title ?: "",
        video = video ?: false,
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: -1
    )
}


fun ShowDto.toSimilarShow(): SimilarShow{
    return SimilarShow(
        adult = adult ?: false,
        backdrop_path = backdrop_path ?: "",
        genre_ids = genre_ids ?: listOf(-1, -2),
        id = id ?: -1,
        original_language = original_language ?: "",
        overview = overview ?: "",
        popularity = popularity ?: 0.0,
        poster_path = poster_path ?: "",
        vote_average = vote_average ?: 0.0,
        vote_count = vote_count ?: -1,
        first_air_date = first_air_date ?: "",
        name = name ?: "",
        origin_country = origin_country ?: listOf("", ""),
        original_name = original_name ?: ""
    )
}