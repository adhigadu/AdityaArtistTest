package com.example.artist.ui.topalbumslisting;


import com.example.artist.models.TopAlbumsResponse;
import com.example.artist.network.TopAlbumsService;

import io.reactivex.Single;
import retrofit2.Retrofit;


public class TopAlbumsInteractorImpl implements TopAlbumsInteractor {
    Retrofit mRetrofit;

    public TopAlbumsInteractorImpl(Retrofit retrofit) {
        mRetrofit = retrofit;
    }

    @Override
    public Single<TopAlbumsResponse> getTopAlbums(String userName, int limit, String apiKey) {
        return mRetrofit.create(TopAlbumsService.class).getTopArtists(userName, limit, apiKey);
    }
}
