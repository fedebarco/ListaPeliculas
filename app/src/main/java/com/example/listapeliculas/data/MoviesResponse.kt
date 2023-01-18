package com.example.listapeliculas.data

import com.squareup.moshi.Json

data class MoviesResponse(
    val page: Long,
    val results: List<ResultMovie>,

    @Json(name = "total_pages")
    val totalPages: Long,

    @Json(name = "total_results")
    val totalResults: Long
)
