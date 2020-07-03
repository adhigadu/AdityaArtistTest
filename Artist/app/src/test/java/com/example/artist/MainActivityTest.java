package com.example.artist;

import com.example.artist.ui.MainActivity;
import com.example.artist.ui.toptrackslisting.TopTracksPresenter;
import com.example.artist.utils.Constants;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;

public class MainActivityTest {
    private MainActivity mainActivity = null;

    @Before
    public void setUp() {
        mainActivity = mock(MainActivity.class);

    }

    @After
    public void tearDown() {

    }

    @Test
    public void testClassVerify() {
        Mockito.verify(mainActivity);

    }
}

