package com.example.artist.ui.toptrackslisting

interface TopTracksPresenter {
    fun onDestroy()
    fun getTopTracks(userName: String, apiKey: String)
}