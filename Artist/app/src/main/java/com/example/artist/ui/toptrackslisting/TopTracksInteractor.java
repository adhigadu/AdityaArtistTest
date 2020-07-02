package com.example.artist.ui.toptrackslisting;


import com.example.artist.models.TopTracksResponse;

import io.reactivex.Single;


public interface TopTracksInteractor {
    Single<TopTracksResponse> getTopTracks(String userName, int limit, String apiKey);

}
