package com.example.artist.ui.topartistslisting;

import com.example.artist.models.Artist;

import java.util.List;

public interface TopArtistsView {
    void showProgress();

    void hideProgress();

    void updateData(List<Artist> topArtists);

    void showError();

    void showEmpty();

    void hidEmpty();

}
