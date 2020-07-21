package com.example.artist.ui.topalbumslisting

import com.example.artist.models.Album

interface TopAlbumsView {
    fun showProgress()
    fun hideProgress()
    fun showError()
    fun updateData(topAlbums: MutableList<Album>)
    fun showEmpty()
    fun hidEmpty()
}