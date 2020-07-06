package com.example.artist.ui.topalbumslisting;


import com.example.artist.models.TopAlbumsResponse;
import com.example.artist.models.TopAlbumsResponseResult;

import io.reactivex.Single;

public interface TopAlbumsInteractor {
    Single<TopAlbumsResponseResult> getTopAlbums(String userName, String apiKey);
}
