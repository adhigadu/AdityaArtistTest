package com.example.artist.ui.toptrackslisting

import com.example.artist.models.TopTracksResponseResult
import io.reactivex.Single

interface TopTracksInteractor {
    fun getTopTracks(userName: String, apiKey: String): Single<TopTracksResponseResult>
}