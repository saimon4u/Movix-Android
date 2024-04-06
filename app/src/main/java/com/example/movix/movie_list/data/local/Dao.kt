package com.example.movix.movie_list.data.local

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface Dao {
    @Upsert
    suspend fun upsertMovieList(movieList: List<MovieEntity>)

    @Query("SELECT * FROM MovieEntity WHERE id = :id")
    suspend fun getMovieById(id: Int): MovieEntity

    @Query("SELECT * FROM MovieEntity WHERE type = :type")
    suspend fun getMovieListByType(type: String): List<MovieEntity>

    @Upsert
    suspend fun upsertShowList(showList: List<ShowEntity>)

    @Query("SELECT * FROM ShowEntity WHERE id = :id")
    suspend fun getShowById(id: Int): ShowEntity

    @Query("SELECT * FROM ShowEntity WHERE type = :type")
    suspend fun getShowListByType(type: String): List<ShowEntity>
}