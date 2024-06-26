package com.example.movix.details.data.remote

import com.example.movix.details.data.remote.response.credits.CastListDto
import com.example.movix.details.data.remote.response.details.movie.MovieDetailsDto
import com.example.movix.details.data.remote.response.details.show.ShowDetailsDto
import com.example.movix.details.data.remote.response.similar.movie.MovieListDto
import com.example.movix.details.data.remote.response.similar.show.ShowListDto
import com.example.movix.details.data.remote.response.videos.VideoListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface DetailsApi {

    @GET("{category}/{id}/credits")
    suspend fun getCredits(
        @Path("category") category: String,
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): CastListDto

    @GET("movie/{id}")
    suspend fun getMovieDetails(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieDetailsDto

    @GET("tv/{id}")
    suspend fun getShowDetails(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ShowDetailsDto


    @GET("{category}/{id}/videos")
    suspend fun getVideoes(
        @Path("category") category: String,
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): VideoListDto

    @GET("movie/{id}/similar")
    suspend fun getSimilarMovie(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): MovieListDto

    @GET("tv/{id}/similar")
    suspend fun getSimilarShow(
        @Path("id") id: Int,
        @Query("api_key") apiKey: String = API_KEY
    ): ShowListDto



    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val BASE_IMG_URL = "https://image.tmdb.org/t/p/w500"
        const val API_KEY = "264cfe95686a0f19b2349f28a569a228"
        const val BASE_THUMBNAIL_URL_PREFIX = "https://img.youtube.com/vi/"
        const val BASE_THUMBNAIL_URL_SUFFIX = "/mqdefault.jpg"
    }
}