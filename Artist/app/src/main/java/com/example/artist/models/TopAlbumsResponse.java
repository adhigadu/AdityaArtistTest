package com.example.artist.models;

import com.google.gson.annotations.SerializedName;


public class TopAlbumsResponse {
    @SerializedName("albummatches")
    TopAlbums topAlbums;

    public TopAlbums getTopAlbums() {
        return topAlbums;
    }

    public void setTopAlbums(TopAlbums topAlbums) {
        this.topAlbums = topAlbums;
    }


}
