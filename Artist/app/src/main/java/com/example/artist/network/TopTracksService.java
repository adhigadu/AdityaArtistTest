package com.example.artist.network;


import com.example.artist.models.TopTracksResponse;
import com.example.artist.models.TopTracksResponseResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TopTracksService {
    @GET("?method=track.search&format=json")
    Single<TopTracksResponseResult> getTopTracks(@Query("track") String user, @Query("api_key") String apiKey);

}
