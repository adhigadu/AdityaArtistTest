package com.example.artist.ui.topartistslisting

import com.example.artist.models.TopArtistsResponseResult
import com.example.artist.network.TopArtistsService
import io.reactivex.Single
import retrofit2.Retrofit

class TopArtistsInteractorImpl(var mRetrofit: Retrofit) : TopArtistsInteractor {
    override fun getTopArtists(userName: String, apiKey: String): Single<TopArtistsResponseResult> {
        return mRetrofit.create(TopArtistsService::class.java).getTopArtists(userName, apiKey)
    }
}