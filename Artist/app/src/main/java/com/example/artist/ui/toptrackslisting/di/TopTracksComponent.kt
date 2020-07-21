package com.example.artist.ui.toptrackslisting.di

import com.example.artist.ui.toptrackslisting.TopTracksFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TopTracksModule::class])
interface TopTracksComponent {
    fun inject(target: TopTracksFragment)
}