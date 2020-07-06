package com.example.artist.ui.topalbumslisting;


public interface TopAlbumsPresenter {
    void onDestroy();

    void getTopAlbums(String userName, String apiKey);
}
