package com.example.artist.ui.topalbumslisting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artist.R
import com.example.artist.adapters.TopAlbumsAdapter
import com.example.artist.models.Album
import com.example.artist.ui.BaseFragment
import com.example.artist.ui.DetailsActivity
import com.example.artist.ui.topalbumslisting.di.DaggerTopAlbumsComponent
import com.example.artist.ui.topalbumslisting.di.TopAlbumsModule
import com.example.artist.utils.Constants
import kotlinx.android.synthetic.main.fragment_top_albums.*
import javax.inject.Inject

open class TopAlbumsFragment : BaseFragment(), TopAlbumsView {

    @Inject
    lateinit var mPresenter: TopAlbumsPresenter

    var mAdapter: TopAlbumsAdapter? = null
    private var mListener: OnFragmentInteractionListener? = null
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_albums, container, false)

        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTopAlbumsComponent.builder().topAlbumsModule(TopAlbumsModule(this)).build().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getTopAlbums(Constants.DEFAULT_LASTFM_USER, Constants.API_KEY)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mListener = if (context is OnFragmentInteractionListener) {
            context
        } else {
            throw RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }

    override fun searchUserName(userName: String) {
        mAdapter?.clearDataset()
        mPresenter.getTopAlbums(userName, Constants.API_KEY)
    }

    override fun showProgress() {
        prgrs_main?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        prgrs_main?.visibility = View.GONE
    }

    override fun showError() {
        Toast.makeText(context, R.string.general_error, Toast.LENGTH_SHORT).show()
    }

    override fun updateData(topAlbums: MutableList<Album>) {
        if (mAdapter == null) {
            mAdapter = context?.let { TopAlbumsAdapter(topAlbums, it, mOnAlbumClickedListener) }
            val layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rclr_albums?.layoutManager = layoutManager
            rclr_albums?.adapter = mAdapter
            mAdapter?.notifyDataSetChanged()
        } else {
            mAdapter?.setDataset(topAlbums)
        }
    }

    override fun showEmpty() {
        empty_layout?.visibility = View.VISIBLE
    }

    override fun hidEmpty() {
        empty_layout?.visibility = View.GONE
    }

    var mOnAlbumClickedListener = View.OnClickListener { view ->
        if (mListener != null) {
            val position = rclr_albums?.getChildAdapterPosition(view)
            val album = position?.let { mAdapter?.getItemByPosition(it) }
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("name", album?.name)
            intent.putExtra("image", album?.imageUrl)
            intent.putExtra("playCount", "")
            intent.putExtra("artist", album?.artist)
            intent.putExtra("duration", "")
            startActivity(intent)
            //   mListener.onAlbumClicked(mAdapter.getItemByPosition(position));
        }
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnFragmentInteractionListener {
        fun onAlbumClicked(album: Album)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    companion object {
        fun newInstance(): TopAlbumsFragment {
            return TopAlbumsFragment()
        }
    }
}