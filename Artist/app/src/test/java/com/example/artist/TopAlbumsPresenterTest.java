package com.example.artist;

import com.example.artist.ui.topalbumslisting.TopAlbumsPresenter;
import com.example.artist.ui.topalbumslisting.TopAlbumsPresenterImpl;
import com.example.artist.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopAlbumsPresenterTest {
    private TopAlbumsPresenter topAlbumsPresenter = null;



    @Before
    public void setUp() {
        topAlbumsPresenter = new TopAlbumsPresenter() {
            @Override
            public void onDestroy() {

            }

            @Override
            public void getTopAlbums(String userName, String apiKey) {

            }
        };

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testGetTopAlbums() {
        topAlbumsPresenter.getTopAlbums("b", Constants.API_KEY);

    }
}
