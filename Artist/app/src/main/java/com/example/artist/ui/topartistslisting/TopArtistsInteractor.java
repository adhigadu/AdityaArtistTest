package com.example.artist.ui.topartistslisting;

import com.example.artist.models.TopArtistsResponse;

import io.reactivex.Single;


public interface TopArtistsInteractor {
    Single<TopArtistsResponse> getTopArtists(String userName, int limit, String apiKey);
}
