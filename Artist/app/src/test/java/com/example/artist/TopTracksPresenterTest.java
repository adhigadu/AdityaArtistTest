package com.example.artist;

import com.example.artist.ui.toptrackslisting.TopTracksPresenter;
import com.example.artist.utils.Constants;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TopTracksPresenterTest {
    private TopTracksPresenter topTracksPresenterTest = null;

    @Before
    public void setUp() {
        topTracksPresenterTest = new TopTracksPresenter() {


            @Override
            public void onDestroy() {

            }

            @Override
            public void getTopTracks(String userName, int limit, String apiKey) {

            }
        };

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testFindContactByName() {
        topTracksPresenterTest.getTopTracks("b",5, Constants.API_KEY);

    }
}
