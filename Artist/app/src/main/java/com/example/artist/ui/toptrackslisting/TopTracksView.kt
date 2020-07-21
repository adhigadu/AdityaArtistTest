package com.example.artist.ui.toptrackslisting

import com.example.artist.models.Track

interface TopTracksView {
    fun showProgress()
    fun hideProgress()
    fun showError()
    fun updateData(tracks: MutableList<Track>)
    fun showEmpty()
    fun hidEmpty()
}