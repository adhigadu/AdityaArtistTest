package com.example.artist;

import com.example.artist.models.Artist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;

public class ArtistModelTest {

    @Test
    public void artistSizeTestTrue() {
        List list = Collections.singletonList(getListOfArtists());
        assertNotNull(list);
        Assert.assertEquals(1, list.size());

    }

    @Test
    public void artistSizeTestFalse() {
        List list = Collections.singletonList(getListOfArtists());
        assertNotNull(list);
        Assert.assertNotEquals(2, list.size());

    }

    public Artist getListOfArtists() {
        Artist artistList = new Artist();
        artistList.setName("Vinayaka");
        artistList.setMbid("12345");
        artistList.setPlaycount("130");
        artistList.setUrl("");
        artistList.setStreamable("");
        return artistList;
    }
}
