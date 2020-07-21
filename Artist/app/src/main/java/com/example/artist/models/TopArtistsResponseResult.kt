package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopArtistsResponseResult(
        @SerializedName("results")
        var topartists: TopArtistsResponse
)