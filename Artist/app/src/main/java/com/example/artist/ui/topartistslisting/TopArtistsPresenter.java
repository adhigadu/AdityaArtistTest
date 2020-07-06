package com.example.artist.ui.topartistslisting;


public interface TopArtistsPresenter {
    void onDestroy();

    void getUserTopArtists(String userName, String apiKey);
}
