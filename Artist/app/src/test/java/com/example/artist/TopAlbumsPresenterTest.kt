package com.example.artist

import com.example.artist.ui.topalbumslisting.*
import com.example.artist.utils.Constants
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import kotlin.text.Typography.times

class TopAlbumsPresenterTest {
    lateinit var topAlbumsPresenter: TopAlbumsPresenterImpl

    @Before
    fun setUp() {
        val fragmentMock = Mockito.mock(TopAlbumsFragment::class.java)
        val topAlbumsInteractorMock = Mockito.mock(TopAlbumsInteractorImpl::class.java)
        topAlbumsPresenter = TopAlbumsPresenterImpl(fragmentMock, topAlbumsInteractorMock)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun test_getTopAlbums_calls_the_update_method_once_on_view() {
        Mockito.`when`(topAlbumsPresenter.getTopAlbums("b", "mockApiKey")).then {
            Mockito.verify(topAlbumsPresenter.mView.updateData(mutableListOf()), Mockito.times(1))
        }
    }
}