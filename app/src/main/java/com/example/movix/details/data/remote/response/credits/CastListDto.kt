package com.example.movix.details.data.remote.response.credits

data class CastListDto(
    val cast: List<CastDto>,
    val crew: List<CrewDto>,
    val id: Int
)