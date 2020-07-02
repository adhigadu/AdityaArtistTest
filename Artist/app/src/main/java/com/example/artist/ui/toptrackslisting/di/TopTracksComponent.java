package com.example.artist.ui.toptrackslisting.di;


import com.example.artist.ui.toptrackslisting.TopTracksFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TopTracksModule.class})
public interface TopTracksComponent {
    void inject(TopTracksFragment target);
}
