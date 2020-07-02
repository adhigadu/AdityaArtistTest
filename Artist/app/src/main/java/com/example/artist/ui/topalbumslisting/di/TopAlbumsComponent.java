package com.example.artist.ui.topalbumslisting.di;



import com.example.artist.ui.topalbumslisting.TopAlbumsFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {TopAlbumsModule.class})
public interface TopAlbumsComponent {
    void inject(TopAlbumsFragment target);
}
