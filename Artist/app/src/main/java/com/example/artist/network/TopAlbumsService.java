package com.example.artist.network;


import com.example.artist.models.TopAlbumsResponse;
import com.example.artist.models.TopAlbumsResponseResult;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface TopAlbumsService {
    @GET("?method=album.search&format=json")
    Single<TopAlbumsResponseResult> getTopArtists(@Query("album") String user, @Query("api_key") String apiKey);

}
