package com.example.artist.ui.toptrackslisting;


public interface TopTracksPresenter {
    void onDestroy();

    void getTopTracks(String userName, String apiKey);

}
