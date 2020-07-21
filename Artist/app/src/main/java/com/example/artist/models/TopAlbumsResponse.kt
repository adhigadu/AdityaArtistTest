package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopAlbumsResponse(
        @SerializedName("albummatches")
        var topAlbums: TopAlbums)