package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopAlbums(@SerializedName("album")
                     var albums: MutableList<Album>)