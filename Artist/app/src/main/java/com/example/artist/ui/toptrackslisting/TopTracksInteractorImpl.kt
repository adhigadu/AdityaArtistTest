package com.example.artist.ui.toptrackslisting

import com.example.artist.models.TopTracksResponseResult
import com.example.artist.network.TopTracksService
import io.reactivex.Single
import retrofit2.Retrofit

class TopTracksInteractorImpl(var mRetrofit: Retrofit) : TopTracksInteractor {
    override fun getTopTracks(userName: String, apiKey: String): Single<TopTracksResponseResult> {
        return mRetrofit.create(TopTracksService::class.java).getTopTracks(userName, apiKey)
    }

}