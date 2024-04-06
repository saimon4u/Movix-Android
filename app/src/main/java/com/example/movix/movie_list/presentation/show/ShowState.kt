package com.example.movix.movie_list.presentation.show

import com.example.movix.core.util.SortType
import com.example.movix.movie_list.domain.model.Show
import com.example.movix.movie_list.presentation.show.util.Genre

data class ShowState(
    val isLoading: Boolean = false,
    val discoverShowPageNo: Int = 1,
    val isShow: Boolean = true,
    val discoverShowList: List<Show> = emptyList(),
    val sortType: String = SortType.Popularity_Descending,
    val genreId: Int = Genre.SCI_FI
)