package com.example.listapeliculas.internet

import com.example.listapeliculas.data.MoviesResponse
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.themoviedb.org/3/trending/movie/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface APIservice {
    @GET("day?")
    suspend fun movies(@Query("api_key") apiKey:String,@Query("language") languaje:String): MoviesResponse

}

object moviesApi {
    val retrofitService : APIservice by lazy { retrofit.create(APIservice::class.java) }
}