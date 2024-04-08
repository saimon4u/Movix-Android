package com.example.movix.movie_list.data.remote

import com.example.movix.movie_list.data.remote.response.MovieListDto
import com.example.movix.movie_list.data.remote.response.ShowListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("movie/{type}")
    suspend fun getMovieList(
        @Path("type") type: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieListDto

    @GET("tv/{type}")
    suspend fun getShowList(
        @Path("type") type: String,
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ShowListDto

    @GET("discover/movie")
    suspend fun getDiscoverMovieList(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("sort_by") sortBy: String,
        @Query("with_genres") genre: Int,
    ): MovieListDto

    @GET("discover/tv")
    suspend fun getDiscoverShowList(
        @Query("page") page: Int,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("sort_by") sortBy: String,
        @Query("with_genres") genre: Int,
    ): ShowListDto

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "264cfe95686a0f19b2349f28a569a228"
    }
}