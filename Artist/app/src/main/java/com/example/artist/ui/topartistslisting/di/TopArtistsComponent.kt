package com.example.artist.ui.topartistslisting.di

import com.example.artist.ui.topartistslisting.TopArtistsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TopArtistsModule::class])
interface TopArtistsComponent {
    fun inject(target: TopArtistsFragment)
}