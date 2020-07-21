package com.example.artist.ui.topartistslisting

import com.example.artist.models.TopArtistsResponseResult
import io.reactivex.Single

interface TopArtistsInteractor {
    fun getTopArtists(userName: String, apiKey: String): Single<TopArtistsResponseResult>
}