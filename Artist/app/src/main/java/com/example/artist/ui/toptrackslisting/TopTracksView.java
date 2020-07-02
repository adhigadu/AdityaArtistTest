package com.example.artist.ui.toptrackslisting;


import com.example.artist.models.Track;

import java.util.List;


public interface TopTracksView {
    void showProgress();

    void hideProgress();

    void showError();

    void updateData(List<Track> tracks);
    void showEmpty();
    void hidEmpty();
}
