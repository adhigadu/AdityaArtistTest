package com.example.artist.ui.topalbumslisting;

import com.example.artist.models.Album;

import java.util.List;


public interface TopAlbumsView {
    void showProgress();

    void hideProgress();

    void showError();

    void updateData(List<Album> topAlbums);

    void showEmpty();

    void hidEmpty();
}
