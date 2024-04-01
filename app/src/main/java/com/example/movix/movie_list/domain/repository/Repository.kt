package com.example.movix.movie_list.domain.repository

import com.example.movix.movie_list.domain.model.Movie
import com.example.movix.movie_list.domain.model.Show
import com.example.movix.movie_list.domain.util.Resource
import kotlinx.coroutines.flow.Flow

interface Repository {
    suspend fun getMovieList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Movie>>>

    suspend fun getShowList(
        forceFetchFromRemote: Boolean,
        type: String,
        page: Int
    ): Flow<Resource<List<Show>>>
}