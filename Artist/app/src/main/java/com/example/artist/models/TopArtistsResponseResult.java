package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopArtistsResponseResult {
    @SerializedName("results")
    private TopArtistsResponse topArtists;

    public TopArtistsResponse getTopartists() {
        return topArtists;
    }

    public void setTopartists(TopArtistsResponse topArtists) {
        this.topArtists = topArtists;
    }
}
