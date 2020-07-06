package com.example.artist.ui.topartistslisting;

import com.example.artist.models.TopArtistsResponse;
import com.example.artist.models.TopArtistsResponseResult;

import io.reactivex.Single;


public interface TopArtistsInteractor {
    Single<TopArtistsResponseResult> getTopArtists(String userName, String apiKey);
}
