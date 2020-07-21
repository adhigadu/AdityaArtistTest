package com.example.artist.ui.topalbumslisting

interface TopAlbumsPresenter {
    fun onDestroy()
    fun getTopAlbums(userName: String, apiKey: String)
}