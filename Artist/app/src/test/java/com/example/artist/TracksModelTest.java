package com.example.artist;
import com.example.artist.models.Track;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class TracksModelTest {
    @Test
    public void tracksSizeTestTrue() {
        List list = Collections.singletonList(getListOfTracks());
        assertNotNull(list);
        Assert.assertEquals(1, list.size());

    }

    @Test
    public void tracksSizeTestFalse() {
        List list = Collections.singletonList(getListOfTracks());
        assertNotNull(list);
        Assert.assertNotEquals(2, list.size());

    }

    public Track getListOfTracks() {
        Track tracksList = new Track();
        tracksList.setName("Vinayaka");
        tracksList.setMbid("12345");
        tracksList.setPlaycount("130");
        tracksList.setUrl("");
        tracksList.setDuration("3000");
        return tracksList;
    }
}
