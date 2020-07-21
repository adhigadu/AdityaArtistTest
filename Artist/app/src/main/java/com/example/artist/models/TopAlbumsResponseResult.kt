package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopAlbumsResponseResult(
        @SerializedName("results")
        var topAlbums: TopAlbumsResponse
)