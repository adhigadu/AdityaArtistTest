package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopAlbumsResponseResult {
    @SerializedName("results")
    TopAlbumsResponse topAlbums;

    public TopAlbumsResponse getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(TopAlbumsResponse topAlbums) {
        this.topAlbums = topAlbums;
    }


}
