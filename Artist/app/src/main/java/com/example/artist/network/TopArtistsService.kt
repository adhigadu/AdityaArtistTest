package com.example.artist.network

import com.example.artist.models.TopArtistsResponseResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TopArtistsService {
    @GET("?method=artist.search&format=json")
    fun getTopArtists(@Query("artist") user: String, @Query("api_key") apiKey: String): Single<TopArtistsResponseResult>
}