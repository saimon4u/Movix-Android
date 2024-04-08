package com.example.movix.details.presentation

sealed class DetailsEvents {
    object Navigate: DetailsEvents()
    data class Play(val videoKey: String): DetailsEvents()
    object Close: DetailsEvents()
}