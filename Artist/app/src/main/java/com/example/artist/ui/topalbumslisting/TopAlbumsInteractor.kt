package com.example.artist.ui.topalbumslisting

import com.example.artist.models.TopAlbumsResponseResult
import io.reactivex.Single

interface TopAlbumsInteractor {
    fun getTopAlbums(userName: String, apiKey: String): Single<TopAlbumsResponseResult>
}