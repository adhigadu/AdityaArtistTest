package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopAlbumsResponseResult {
    public TopAlbumsResponse getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(TopAlbumsResponse topAlbums) {
        this.topAlbums = topAlbums;
    }

    @SerializedName("results")
    TopAlbumsResponse topAlbums;
}
