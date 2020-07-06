package com.example.artist.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Album {

    @SerializedName("name")
    private String name;

    @SerializedName("artist")
    private String artist;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private List<ImageItem> image;
    @SerializedName("streamable")
    private String streamable;
    @SerializedName("mbid")
    private String mbid;


    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }
    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ImageItem> getImage() {
        return image;
    }

    public void setImage(List<ImageItem> image) {
        this.image = image;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        if (getImage() != null && getImage().size() > 0) {
            for (ImageItem img :
                    getImage()) {
                if (img.getSize().equalsIgnoreCase("large")) {
                    return img.getUrl();
                }
            }
        }
        return null;
    }

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }
}
