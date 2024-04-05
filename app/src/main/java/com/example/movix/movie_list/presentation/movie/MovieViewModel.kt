package com.example.movix.movie_list.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movix.movie_list.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
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
        getDiscoverMovies(false)
    }

    private fun getDiscoverMovies(forceFetchFromRemote: Boolean) {
        viewModelScope.launch {
            _movieState.update {
                it.copy(
                    isLoading = true
                )
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
                getDiscoverMovies(true)
            }
            is MovieEvents.SelectGenre -> {
                _movieState.update {
                    it.copy(
                        genreId = event.genreId
                    )
                }
            }
            is MovieEvents.Sort -> {
                _movieState.update {
                    it.copy(
                        sortType = event.sortType
                    )
                }
            }
        }
    }
}