package com.example.artist.network

import com.example.artist.models.TopTracksResponseResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TopTracksService {
    @GET("?method=track.search&format=json")
    fun getTopTracks(@Query("track") user: String, @Query("api_key") apiKey: String): Single<TopTracksResponseResult>
}