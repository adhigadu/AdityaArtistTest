package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopTracksResponseResult {
    @SerializedName("results")
    private TopTracksResponse topTracks;

    public TopTracksResponse getTopTracks() {
        return topTracks;
    }

    public void setToptracks(TopTracksResponse topTracks) {
        this.topTracks = topTracks;
    }
}
