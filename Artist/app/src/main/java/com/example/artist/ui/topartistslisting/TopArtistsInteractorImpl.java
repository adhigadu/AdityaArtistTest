package com.example.artist.ui.topartistslisting;


import com.example.artist.models.TopArtistsResponse;
import com.example.artist.models.TopArtistsResponseResult;
import com.example.artist.network.TopArtistsService;

import io.reactivex.Single;
import retrofit2.Retrofit;


public class TopArtistsInteractorImpl implements TopArtistsInteractor {
    Retrofit mRetrofit;

    public TopArtistsInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopArtistsResponseResult> getTopArtists(String userName, String apiKey) {
        return mRetrofit.create(TopArtistsService.class).getTopArtists(userName, apiKey);
    }
}
