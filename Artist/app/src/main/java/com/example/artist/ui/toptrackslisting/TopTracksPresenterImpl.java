package com.example.artist.ui.toptrackslisting;

import com.example.artist.models.TopTracksResponse;
import com.example.artist.models.TopTracksResponseResult;
import com.example.artist.models.Track;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class TopTracksPresenterImpl implements TopTracksPresenter {
    Disposable mDisposable;
    TopTracksInteractor mInteractor;
    TopTracksView mView;

    public TopTracksPresenterImpl(TopTracksView view, TopTracksInteractor interactor) {
        this.mView = view;
        this.mInteractor = interactor;
    }

    @Override
    public void getTopTracks(String userName, String apiKey) {
        disposeRequest();
        mView.showProgress();
        mView.hidEmpty();
        mDisposable = mInteractor.getTopTracks(userName, apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<TopTracksResponseResult, List<Track>>() {
                    @Override
                    public List<Track> apply(@NonNull TopTracksResponseResult topTracksResponse) throws Exception {
                        if (topTracksResponse != null && topTracksResponse.getTopTracks() != null) {
                            return topTracksResponse.getTopTracks().getTopTracks().getTracks();
                        }
                        return new ArrayList<Track>();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Track>>() {
                    @Override
                    public void accept(@NonNull List<Track> tracks) throws Exception {
                        mView.hideProgress();
                        if (tracks.size() == 0) {
                            mView.showEmpty();
                        }
                        mView.updateData(tracks);
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
