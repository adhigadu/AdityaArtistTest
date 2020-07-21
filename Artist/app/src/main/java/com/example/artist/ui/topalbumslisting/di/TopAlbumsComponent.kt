package com.example.artist.ui.topalbumslisting.di

import com.example.artist.ui.topalbumslisting.TopAlbumsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TopAlbumsModule::class])
interface TopAlbumsComponent {
    fun inject(target: TopAlbumsFragment)
}