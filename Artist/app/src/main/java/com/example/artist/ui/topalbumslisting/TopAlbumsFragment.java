package com.example.artist.ui.topalbumslisting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.artist.R;
import com.example.artist.adapters.TopAlbumsAdapter;
import com.example.artist.models.Album;
import com.example.artist.ui.BaseFragment;
import com.example.artist.ui.DetailsActivity;
import com.example.artist.ui.topalbumslisting.di.DaggerTopAlbumsComponent;
import com.example.artist.ui.topalbumslisting.di.TopAlbumsModule;
import com.example.artist.utils.Constants;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TopAlbumsFragment extends BaseFragment implements TopAlbumsView {
    @BindView(R.id.rclr_albums)
    RecyclerView albumsRecyclerView;
    @BindView(R.id.prgrs_main)
    ProgressBar mainprogressBar;
    @BindView(R.id.empty_layout)
    View emptyLayout;
    @Inject
    TopAlbumsPresenter mPresenter;
    TopAlbumsAdapter mAdapter;
    private OnFragmentInteractionListener mListener;

    public TopAlbumsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_top_albums, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerTopAlbumsComponent.builder().topAlbumsModule(new TopAlbumsModule(this)).build().inject(this);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.getTopAlbums(Constants.DEFAULT_LASTFM_USER, Constants.API_KEY);
    }


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    protected void searchUserName(String userName) {
        if (mAdapter != null) {
            mAdapter.clearDataset();
        }
        mPresenter.getTopAlbums(userName, Constants.API_KEY);

    }

    @Override
    public void showProgress() {
        mainprogressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mainprogressBar.setVisibility(View.GONE);
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), R.string.general_error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateData(List<Album> topAlbums) {
        if (mAdapter == null) {

            mAdapter = new TopAlbumsAdapter(topAlbums, getContext(), mOnAlbumClickedListener);
            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
            albumsRecyclerView.setLayoutManager(layoutManager);
            albumsRecyclerView.setAdapter(mAdapter);
            mAdapter.notifyDataSetChanged();
        } else {
            mAdapter.setDataset(topAlbums);
        }


    }

    @Override
    public void showEmpty() {
        emptyLayout.setVisibility(View.VISIBLE);
    }

    @Override
    public void hidEmpty() {
        emptyLayout.setVisibility(View.GONE);
    }

    View.OnClickListener mOnAlbumClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = albumsRecyclerView.getChildAdapterPosition(view);
                Album album = mAdapter.getItemByPosition(position);
                Intent intent = new Intent(getContext(), DetailsActivity.class);
                intent.putExtra("name", album.getName());
                intent.putExtra("image", album.getImageUrl());
                intent.putExtra("playCount", album.getPlaycount());
                intent.putExtra("artist", album.getArtist().getName());
                intent.putExtra("duration", "");
                startActivity(intent);
                //   mListener.onAlbumClicked(mAdapter.getItemByPosition(position));
            }
        }
    };

    public static TopAlbumsFragment newInstance() {
        return new TopAlbumsFragment();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    public interface OnFragmentInteractionListener {

        void onAlbumClicked(Album album);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }
}
