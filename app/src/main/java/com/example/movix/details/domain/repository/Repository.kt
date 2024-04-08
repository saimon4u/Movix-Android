package com.example.movix.details.domain.repository

import com.example.movix.details.domain.model.Cast
import com.example.movix.details.domain.model.Crew
import com.example.movix.details.domain.model.MovieDetails
import com.example.movix.details.domain.model.ShowDetails
import com.example.movix.details.domain.model.SimilarMovie
import com.example.movix.details.domain.model.SimilarShow
import com.example.movix.details.domain.model.Video
import com.example.movix.movie_list.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {

    suspend fun getCrews(
        category: String,
        id: Int
    ): Flow<Resource<List<Crew>>>

    suspend fun getCasts(
        category: String,
        id: Int
    ): Flow<Resource<List<Cast>>>

    suspend fun getMovieDetails(
        id: Int
    ): Flow<Resource<MovieDetails>>

    suspend fun getShowDetails(
        id: Int
    ): Flow<Resource<ShowDetails>>

    suspend fun getVideos(
        category: String,
        id: Int
    ): Flow<Resource<List<Video>>>

    suspend fun getSimilarMovies(
        id: Int
    ): Flow<Resource<List<SimilarMovie>>>

    suspend fun getSimilarShows(
        id: Int
    ): Flow<Resource<List<SimilarShow>>>
}