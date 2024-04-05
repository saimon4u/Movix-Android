package com.example.movix.movie_list.presentation.movie

import androidx.lifecycle.ViewModel
import com.example.movix.movie_list.domain.repository.Repository
import com.example.movix.movie_list.domain.util.Category
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MovieViewModel @Inject constructor(
    private val repository: Repository
): ViewModel(){

    private var _movieState = MutableStateFlow(MovieState())
    val movieState = _movieState.asStateFlow()

//    init {
//        getPopular(false, Category.MOVIE)
//        getRated(false, Category.SHOW)
//    }


//    fun onEvent(event: HomeEvents){
//        when(event){
//            is HomeEvents.Navigate -> {
//                _homeState.update {
//                    it.copy(
//                        isHome = !homeState.value.isHome
//                    )
//                }
//            }
//            is HomeEvents.Paginate -> {
//                if(event.type == Type.POPULAR){
//                    if(event.category == Category.MOVIE){
//                        getPopular(true, Category.MOVIE)
//                    }else{
//                        getPopular(true, Category.SHOW)
//                    }
//                }else{
//                    if(event.category == Category.MOVIE){
//                        getRated(true, Category.MOVIE)
//                    }else{
//                        getRated(true, Category.SHOW)
//                    }
//                }
//            }
//            is HomeEvents.Select -> {
//                if(event.type == Type.POPULAR){
//                    if(event.category == Category.MOVIE){
//                        getPopular(true, Category.MOVIE)
//                    }else{
//                        getPopular(true, Category.SHOW)
//                        Log.e("TAG", "popular show loaded", )
//                    }
//                }else{
//                    if(event.category == Category.MOVIE){
//                        getRated(true, Category.MOVIE)
//                    }else{
//                        getRated(true, Category.SHOW)
//                    }
//                }
//            }
//            is HomeEvents.Toggle ->{
//                when(event.category){
//                    Category.SHOW ->{
//                        if(event.list == Type.POPULAR){
//                            _homeState.update {
//                                it.copy(
//                                    isPopularShow = true,
//                                    isPopularMovie = false,
//                                )
//                            }
//                            getPopular(false, Category.SHOW)
////                            Log.e("TAG", "Popular Show Clicked" )
//                        }else{
//                            _homeState.update {
//                                it.copy(
//                                    isRatedShow = true,
//                                    isRatedMovie = false,
//                                )
//                            }
//                            getRated(false, Category.SHOW)
////                            Log.e("TAG", "Rated Show Clicked" )
//                        }
//                    }
//                    Category.MOVIE->{
//                        if(event.list == Type.POPULAR){
//                            _homeState.update {
//                                it.copy(
//                                    isPopularMovie = true,
//                                    isPopularShow = false,
//                                )
//                            }
//                            getPopular(false, Category.MOVIE)
////                            Log.e("TAG", "Popular Movie Clicked" )
//                        }else{
//                            _homeState.update {
//                                it.copy(
//                                    isRatedMovie = true,
//                                    isRatedShow = false
//                                )
//                            }
//                            getRated(false, Category.MOVIE)
////                            Log.e("TAG", "Rated Movie Clicked" )
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//    private fun getPopular(forceFetchFromRemote: Boolean, category: String){
//        viewModelScope.launch {
//            _homeState.update {
//                it.copy(
//                    isLoading = true
//                )
//            }
//
//            if(Category.SHOW == category){
//                repository.getShowList(
//                    forceFetchFromRemote = forceFetchFromRemote,
//                    type = Type.POPULAR,
//                    page = homeState.value.popularShowListPageNo
//                ).collectLatest {result->
//                    when(result){
//                        is Resource.Error -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = false
//                                )
//                            }
//                        }
//                        is Resource.Loading -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = result.isLoading
//                                )
//                            }
//                        }
//                        is Resource.Success -> {
//                            result.data?.let {list ->
//                                _homeState.update {
//                                    it.copy(
//                                        popularShowList = homeState.value.popularShowList + list,
//                                        popularShowListPageNo = homeState.value.popularShowListPageNo + 1
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }else{
//                repository.getMovieList(
//                    forceFetchFromRemote = forceFetchFromRemote,
//                    type = Type.POPULAR,
//                    page = homeState.value.popularMovieListPageNo
//                ).collectLatest {result->
//                    when(result){
//                        is Resource.Error -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = false
//                                )
//                            }
//                        }
//                        is Resource.Loading -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = result.isLoading
//                                )
//                            }
//                        }
//                        is Resource.Success -> {
//                            result.data?.let {list ->
//                                _homeState.update {
//                                    it.copy(
//                                        popularMovieList = homeState.value.popularMovieList + list,
//                                        popularMovieListPageNo = homeState.value.popularMovieListPageNo + 1
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//
//    private fun getRated(forceFetchFromRemote: Boolean, category: String){
//        viewModelScope.launch {
//            _homeState.update {
//                it.copy(
//                    isLoading = true
//                )
//            }
//
//            if(Category.SHOW == category){
//                repository.getShowList(
//                    forceFetchFromRemote = forceFetchFromRemote,
//                    type = Type.TOP_RATED,
//                    page = homeState.value.ratedShowListPageNo
//                ).collectLatest {result->
//                    when(result){
//                        is Resource.Error -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = false
//                                )
//                            }
//                        }
//                        is Resource.Loading -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = result.isLoading
//                                )
//                            }
//                        }
//                        is Resource.Success -> {
//                            result.data?.let {list ->
//                                _homeState.update {
//                                    it.copy(
//                                        ratedShowList = homeState.value.ratedShowList + list,
//                                        ratedShowListPageNo = homeState.value.ratedShowListPageNo + 1
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }else{
//                repository.getMovieList(
//                    forceFetchFromRemote = forceFetchFromRemote,
//                    type = Type.TOP_RATED,
//                    page = homeState.value.ratedMovieListPageNo
//                ).collectLatest {result->
//                    when(result){
//                        is Resource.Error -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = false
//                                )
//                            }
//                        }
//                        is Resource.Loading -> {
//                            _homeState.update {
//                                it.copy(
//                                    isLoading = result.isLoading
//                                )
//                            }
//                        }
//                        is Resource.Success -> {
//                            result.data?.let {list ->
//                                _homeState.update {
//                                    it.copy(
//                                        ratedMovieList = homeState.value.ratedMovieList + list,
//                                        ratedMovieListPageNo = homeState.value.ratedMovieListPageNo + 1
//                                    )
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//
//        }
//    }

}