package com.example.movix.details.presentation

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movix.details.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Category
import com.example.movix.movie_list.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: Repository,
    private val savedStateHandle: SavedStateHandle
): ViewModel(){

    private val contentCategory = savedStateHandle.get<String>("category")
    private val id = savedStateHandle.get<Int>("id")

    private var _detailsState = MutableStateFlow(DetailsState())
    val detailsState = _detailsState.asStateFlow()



    init {
        Log.e("Tag", id.toString() )
        if(contentCategory == "movie"){
            getMovieDetails(id!!)
            getCredits(id)
            getVideos(id)
            getSimilar(id)
        }else{
            getShowDetails(id!!)
            getCredits(id)
            getVideos(id)
            getSimilar(id)
        }
    }

    fun onEvent(event: DetailsEvents){
        when(event){
            is DetailsEvents.Navigate -> {

            }
            is DetailsEvents.Play -> {
                _detailsState.update {
                    it.copy(
                        isPlaying = true,
                        videoId = event.videoKey
                    )
                }
            }

            is DetailsEvents.Close -> {
                _detailsState.update {
                    it.copy(
                        isPlaying = false,
                        videoId = ""
                    )
                }
            }
        }
    }

    private fun getSimilar(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(
                    isLoading = true
                )
            }

            if(contentCategory == Category.MOVIE){
                repository.getSimilarMovies(id).collectLatest {result->
                    when(result){
                        is Resource.Error -> {
                            _detailsState.update {
                                it.copy(
                                    isLoading = false
                                )
                            }
                        }
                        is Resource.Loading -> {
                            _detailsState.update {
                                it.copy(
                                    isLoading = result.isLoading
                                )
                            }
                        }
                        is Resource.Success -> {
                            _detailsState.update {
                                it.copy(
                                    similarMovies = result.data ?: emptyList()
                                )
                            }
                        }
                    }
                }
            }
            else{
                repository.getSimilarShows(id).collectLatest {result->
                    when(result){
                        is Resource.Error -> {
                            _detailsState.update {
                                it.copy(
                                    isLoading = false
                                )
                            }
                        }
                        is Resource.Loading -> {
                            _detailsState.update {
                                it.copy(
                                    isLoading = result.isLoading
                                )
                            }
                        }
                        is Resource.Success -> {
                            _detailsState.update {
                                it.copy(
                                    similarShows = result.data ?: emptyList()
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun getVideos(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(
                    isLoading = true
                )
            }
            
            repository.getVideos(
                category = contentCategory!!,
                id = id
            ).collectLatest { result->
                when(result){
                    is Resource.Error -> {
                        _detailsState.update { 
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _detailsState.update { 
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _detailsState.update { 
                            it.copy(
                                videoList = result.data ?: emptyList()
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getCredits(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(
                    isLoading = true
                )
            }

            repository.getCasts(contentCategory!!, id).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _detailsState.update {
                            it.copy(
                                castList = result.data ?: emptyList()
                            )
                        }
                    }
                }
            }

            repository.getCrews(contentCategory, id).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _detailsState.update {
                            it.copy(
                                crewList = result.data ?: emptyList()
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getShowDetails(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(
                    isLoading = true
                )
            }


            repository.getShowDetails(id).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _detailsState.update {
                            it.copy(
                                showDetails = result.data,
                                category = Category.SHOW
                            )
                        }
                    }
                }
            }
        }
    }

    private fun getMovieDetails(id: Int) {
        viewModelScope.launch {
            _detailsState.update {
                it.copy(
                    isLoading = true
                )
            }


            repository.getMovieDetails(id).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _detailsState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        _detailsState.update {
                            it.copy(
                                movieDetails = result.data,
                                category = Category.MOVIE
                            )
                        }
                    }
                }
            }
        }
    }

}