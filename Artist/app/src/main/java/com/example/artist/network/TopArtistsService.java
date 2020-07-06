package com.example.artist.network;


import com.example.artist.models.TopArtistsResponse;
import com.example.artist.models.TopArtistsResponseResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TopArtistsService {
    @GET("?method=artist.search&format=json")
    Single<TopArtistsResponseResult> getTopArtists(@Query("artist") String user, @Query("api_key") String apiKey);
}
