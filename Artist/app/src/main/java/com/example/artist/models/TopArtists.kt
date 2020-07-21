package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class TopArtists(
        @SerializedName("artist")
        var artists: MutableList<Artist>
)