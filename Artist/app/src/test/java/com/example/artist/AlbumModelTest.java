package com.example.artist;

import com.example.artist.models.Album;

import org.junit.Assert;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertNotNull;


public class AlbumModelTest {
    @Test
    public void ablumSizeTestTrue() {
        List list = Collections.singletonList(getListOfAlbums());
        assertNotNull(list);
        Assert.assertEquals(1, list.size());

    }

    @Test
    public void ablumSizeTestFalse() {
        List list = Collections.singletonList(getListOfAlbums());
        assertNotNull(list);
        Assert.assertNotEquals(2, list.size());

    }

    public Album getListOfAlbums() {
        Album albumList = new Album();
        albumList.setName("Vinayaka");
        albumList.setMbid("12345");
        albumList.setPlaycount("130");
        albumList.setUrl("");
        return albumList;
    }
}
