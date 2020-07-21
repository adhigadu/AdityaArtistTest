package com.example.artist.ui.topalbumslisting

import com.example.artist.models.TopAlbumsResponseResult
import com.example.artist.network.TopAlbumsService
import io.reactivex.Single
import retrofit2.Retrofit

class TopAlbumsInteractorImpl(var mRetrofit: Retrofit) : TopAlbumsInteractor {
    override fun getTopAlbums(userName: String, apiKey: String): Single<TopAlbumsResponseResult> {
        return mRetrofit.create(TopAlbumsService::class.java).getTopArtists(userName, apiKey)
    }
}