package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopTracks(
        @SerializedName("track")
        var tracks: MutableList<Track>
)