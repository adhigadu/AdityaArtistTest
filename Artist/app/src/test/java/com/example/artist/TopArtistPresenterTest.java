package com.example.artist;

import com.example.artist.ui.topalbumslisting.TopAlbumsPresenter;
import com.example.artist.ui.topartistslisting.TopArtistsPresenter;
import com.example.artist.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopArtistPresenterTest {
    private TopArtistsPresenter topArtistPresenterTest = null;



    @Before
    public void setUp() {
        topArtistPresenterTest = new TopArtistsPresenter() {

            @Override
            public void onDestroy() {

            }

            @Override
            public void getUserTopArtists(String userName, int limit, String apiKey) {

            }
        };

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testFindContactByName() {
        topArtistPresenterTest.getUserTopArtists("b",5, Constants.API_KEY);

    }
}