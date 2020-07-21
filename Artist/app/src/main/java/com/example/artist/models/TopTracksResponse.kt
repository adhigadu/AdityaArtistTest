package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopTracksResponse(
        @SerializedName("trackmatches")
        var topTracks: TopTracks
)