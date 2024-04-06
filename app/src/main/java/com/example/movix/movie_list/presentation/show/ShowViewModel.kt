package com.example.movix.movie_list.presentation.show

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
class ShowViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    private var _showState = MutableStateFlow(ShowState())
    val showState = _showState.asStateFlow()

    init {
        getDiscoverShows(false, Type.DISCOVER)
    }

    private fun getDiscoverShows(forceFetchFromRemote: Boolean, type: String) {
        viewModelScope.launch {
            _showState.update {
                it.copy(
                    isLoading = true
                )
            }


            repository.getDiscoverShows(
                forceFetchFromRemote = forceFetchFromRemote,
                page = showState.value.discoverShowPageNo,
                sortBy = showState.value.sortType,
                genre = showState.value.genreId,
                type = type
            ).collectLatest {result->
                when(result){
                    is Resource.Error -> {
                        _showState.update {
                            it.copy(
                                isLoading = false
                            )
                        }
                    }
                    is Resource.Loading -> {
                        _showState.update {
                            it.copy(
                                isLoading = result.isLoading
                            )
                        }
                    }
                    is Resource.Success -> {
                        result.data?.let {list ->
                            _showState.update {
                                it.copy(
                                    discoverShowList = showState.value.discoverShowList + list,
                                    discoverShowPageNo = showState.value.discoverShowPageNo + 1
                                )
                            }
                        }
                    }
                }
            }
        }
    }


    fun onEvent(event: ShowEvents){
        when(event){
            is ShowEvents.Navigate -> {
                _showState.update {
                    it.copy(
                        isShow = !showState.value.isShow
                    )
                }
            }
            is ShowEvents.Paginate -> {
                getDiscoverShows(true, event.type)
            }
            is ShowEvents.SelectGenre -> {
                _showState.update {
                    it.copy(
                        genreId = event.genreId,
                        discoverShowList = emptyList(),
                        discoverShowPageNo = 1
                    )
                }
                getDiscoverShows(true, Type.DISCOVER)
            }
            is ShowEvents.Sort -> {
                _showState.update {
                    it.copy(
                        sortType = event.sortType,
                        discoverShowList = emptyList(),
                        discoverShowPageNo = 1
                    )
                }
                getDiscoverShows(true, Type.DISCOVER)
            }
        }
    }
}