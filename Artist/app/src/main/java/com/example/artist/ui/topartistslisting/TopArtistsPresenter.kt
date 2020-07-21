package com.example.artist.ui.topartistslisting

interface TopArtistsPresenter {
    fun onDestroy()
    fun getUserTopArtists(userName: String, apiKey: String)
}