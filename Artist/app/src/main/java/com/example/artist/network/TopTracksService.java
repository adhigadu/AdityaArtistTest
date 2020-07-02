package com.example.artist.network;


import com.example.artist.models.TopTracksResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TopTracksService {
    @GET("?method=user.gettoptracks&format=json")
    Single<TopTracksResponse> getTopTracks(@Query("user") String user, @Query("limit") int limit, @Query("api_key") String apiKey);

}
