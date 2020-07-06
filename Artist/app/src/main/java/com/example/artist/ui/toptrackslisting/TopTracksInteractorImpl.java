package com.example.artist.ui.toptrackslisting;


import com.example.artist.models.TopTracksResponse;
import com.example.artist.models.TopTracksResponseResult;
import com.example.artist.network.TopTracksService;

import io.reactivex.Single;
import retrofit2.Retrofit;


public class TopTracksInteractorImpl implements TopTracksInteractor {
    Retrofit mRetrofit;

    public TopTracksInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopTracksResponseResult> getTopTracks(String userName, String apiKey) {
        return mRetrofit.create(TopTracksService.class).getTopTracks(userName, apiKey);
    }
}
