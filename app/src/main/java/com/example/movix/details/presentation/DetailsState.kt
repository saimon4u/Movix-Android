package com.example.movix.details.presentation

import com.example.movix.details.domain.model.Cast
import com.example.movix.details.domain.model.Crew
import com.example.movix.details.domain.model.MovieDetails
import com.example.movix.details.domain.model.ShowDetails
import com.example.movix.details.domain.model.SimilarMovie
import com.example.movix.details.domain.model.SimilarShow
import com.example.movix.details.domain.model.Video
import com.example.movix.movie_list.domain.util.Category


data class DetailsState(
    val isLoading: Boolean = false,
    val isPlaying: Boolean = false,
    val videoId: String = "",
    val castList: List<Cast> = emptyList(),
    val crewList: List<Crew> = emptyList(),
    val movieDetails: MovieDetails? = null,
    val showDetails: ShowDetails? = null,
    val category: String = Category.MOVIE,
    val videoList: List<Video> = emptyList(),
    val similarShows: List<SimilarShow> = emptyList(),
    val similarMovies: List<SimilarMovie> = emptyList()
)