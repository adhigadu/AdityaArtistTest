package com.example.artist.ui.topalbumslisting;

import com.example.artist.models.Album;
import com.example.artist.models.TopAlbumsResponse;
import com.example.artist.models.TopAlbumsResponseResult;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class TopAlbumsPresenterImpl implements TopAlbumsPresenter {
    Disposable mDisposable;
    TopAlbumsInteractor mInteractor;
    TopAlbumsView mView;

    public TopAlbumsPresenterImpl(TopAlbumsView view, TopAlbumsInteractor interactor) {
        this.mView = view;
        this.mInteractor = interactor;
    }

    @Override
    public void getTopAlbums(String userName, String apiKey) {
        mView.showProgress();
        mView.hidEmpty();
        disposeRequest();
        mDisposable = mInteractor.getTopAlbums(userName, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TopAlbumsResponseResult, List<Album>>() {
                    @Override
                    public List<Album> apply(@NonNull TopAlbumsResponseResult topAlbumsResponse) throws Exception {
                        if (topAlbumsResponse != null && topAlbumsResponse.getTopAlbums() != null && topAlbumsResponse.getTopAlbums() != null) {
                            return topAlbumsResponse.getTopAlbums().getTopAlbums().getAlbums();
                        }
                        return new ArrayList<Album>();
                    }
                }).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Album>>() {
                    @Override
                    public void accept(@NonNull List<Album> albums) throws Exception {
                        mView.hideProgress();
                        if (albums.size() == 0) {
                            mView.showEmpty();
                        }
                        mView.updateData(albums);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(@NonNull Throwable throwable) throws Exception {
                        mView.hideProgress();
                        mView.showError();
                    }
                });
    }

    @Override
    public void onDestroy() {
        disposeRequest();
    }

    private void disposeRequest() {
        if (mDisposable != null && !mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

}
