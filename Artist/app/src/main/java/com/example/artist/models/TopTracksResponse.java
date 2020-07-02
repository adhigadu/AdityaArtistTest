package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopTracksResponse {
    @SerializedName("toptracks")
    private TopTracks topTracks;

    public TopTracks getTopTracks() {
        return topTracks;
    }

    public void setToptracks(TopTracks topTracks) {
        this.topTracks = topTracks;
    }
}
