package com.example.movix.movie_list.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movix.movie_list.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Resource
import com.example.movix.movie_list.domain.util.Type
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    private var _movieState = MutableStateFlow(MovieState())
    val movieState = _movieState.asStateFlow()

    init {
        getDiscoverMovies(false, Type.DISCOVER)
    }

    private fun getDiscoverMovies(forceFetchFromRemote: Boolean, type: String) {
        viewModelScope.launch {
            _movieState.update {
                it.copy(
                    isLoading = true
                )
            }


            repository.getDiscoverMovies(
                forceFetchFromRemote = forceFetchFromRemote,
                page = movieState.value.discoverMoviePageNo,
                sortBy = movieState.value.sortType,
                genre = movieState.value.genreId,
                type = type
            ).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _movieState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _movieState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let {list ->
                            _movieState.update {
                                it.copy(
                                    discoverMovieList = movieState.value.discoverMovieList + list,
                                    discoverMoviePageNo = movieState.value.discoverMoviePageNo + 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    fun onEvent(event: MovieEvents){
        when(event){
            is MovieEvents.Navigate -> {
                _movieState.update {
                    it.copy(
                        isMovie = !movieState.value.isMovie
                    )
                }
            }
            is MovieEvents.Paginate -> {
                getDiscoverMovies(true, event.type)
            }
            is MovieEvents.SelectGenre -> {
                _movieState.update {
                    it.copy(
                        genreId = event.genreId,
                        discoverMovieList = emptyList(),
                        discoverMoviePageNo = 1
                    )
                }
                getDiscoverMovies(true, Type.DISCOVER)
            }
            is MovieEvents.Sort -> {
                _movieState.update {
                    it.copy(
                        sortType = event.sortType,
                        discoverMovieList = emptyList(),
                        discoverMoviePageNo = 1
                    )
                }
                getDiscoverMovies(true, Type.DISCOVER)
            }
        }
    }
}