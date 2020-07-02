package com.example.artist.ui.topalbumslisting;



import com.example.artist.models.TopAlbumsResponse;

import io.reactivex.Single;

public interface TopAlbumsInteractor {
    Single<TopAlbumsResponse> getTopAlbums(String userName, int limit, String apiKey);
}
