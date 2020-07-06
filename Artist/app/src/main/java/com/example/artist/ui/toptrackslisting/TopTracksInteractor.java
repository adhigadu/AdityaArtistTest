package com.example.artist.ui.toptrackslisting;


import com.example.artist.models.TopTracksResponse;
import com.example.artist.models.TopTracksResponseResult;

import io.reactivex.Single;


public interface TopTracksInteractor {
    Single<TopTracksResponseResult> getTopTracks(String userName, String apiKey);

}
