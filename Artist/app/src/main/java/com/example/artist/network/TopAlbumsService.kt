package com.example.artist.network

import com.example.artist.models.TopAlbumsResponseResult
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TopAlbumsService {
    @GET("?method=album.search&format=json")
    fun getTopArtists(@Query("album") user: String, @Query("api_key") apiKey: String): Single<TopAlbumsResponseResult>
}