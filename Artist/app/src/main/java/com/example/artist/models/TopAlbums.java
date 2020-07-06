package com.example.artist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class TopAlbums {
    @SerializedName("album")
    List<Album> albums;

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }


}
