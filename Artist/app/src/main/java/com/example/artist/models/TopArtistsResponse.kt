package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopArtistsResponse(
        @SerializedName("artistmatches")
        var topartists: TopArtists
)