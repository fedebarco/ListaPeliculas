package com.example.listapeliculas.data

import com.squareup.moshi.Json

data class ResultMovie(
    val adult: Boolean= false,

    @Json(name = "backdrop_path")
    val backdropPath: String ="",

    val id: Long = 0,
    val title: String = "",

    @Json(name = "original_language")
    val originalLanguage: String = "",

    @Json(name = "original_title")
    val originalTitle: String = "0",

    val overview: String = "",

    @Json(name = "poster_path")
    val posterPath: String = "",

    @Json(name = "media_type")
    val mediaType: String = "",

    @Json(name = "genre_ids")
    val genreIDS: List<Long> = listOf(),

    val popularity: Double = 0.0,

    @Json(name = "release_date")
    val releaseDate: String = "",

    val video: Boolean =false,

    @Json(name = "vote_average")
    val voteAverage: Double = 0.0,

    @Json(name = "vote_count")
    val voteCount: Long = 0
)
