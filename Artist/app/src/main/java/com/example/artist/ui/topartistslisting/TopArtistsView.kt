package com.example.artist.ui.topartistslisting

import com.example.artist.models.Artist

interface TopArtistsView {
    fun showProgress()
    fun hideProgress()
    fun updateData(topArtists: MutableList<Artist>)
    fun showError()
    fun showEmpty()
    fun hidEmpty()
}