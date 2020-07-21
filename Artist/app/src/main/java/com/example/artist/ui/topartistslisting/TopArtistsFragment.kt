package com.example.artist.ui.topartistslisting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artist.R
import com.example.artist.adapters.TopArtistsAdapter
import com.example.artist.models.Artist
import com.example.artist.ui.BaseFragment
import com.example.artist.ui.DetailsActivity
import com.example.artist.ui.topartistslisting.di.DaggerTopArtistsComponent
import com.example.artist.ui.topartistslisting.di.TopArtistsModule
import com.example.artist.utils.Constants
import kotlinx.android.synthetic.main.fragment_artists.*
import javax.inject.Inject

class TopArtistsFragment : BaseFragment(), TopArtistsView {

    var mListener: OnFragmentInteractionListener? = null


    @Inject
    lateinit var mPresenter: TopArtistsPresenter
    var mAdapter: TopArtistsAdapter? = null
    override fun searchUserName(userName: String) {
        mAdapter?.clearDataset()
        mPresenter.getUserTopArtists(userName, Constants.API_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_artists, container, false)
        return view
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTopArtistsComponent.builder().topArtistsModule(TopArtistsModule(this)).build().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getUserTopArtists(Constants.DEFAULT_LASTFM_USER, Constants.API_KEY)
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

    override fun showProgress() {
        prgrs_main?.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        prgrs_main?.visibility = View.GONE
    }

    override fun updateData(topArtists: MutableList<Artist>) {
        if (mAdapter == null) {
            mAdapter = context?.let { TopArtistsAdapter(topArtists, it, onArtistclickedListener) }
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rclr_artists?.layoutManager = linearLayoutManager
            rclr_artists?.adapter = mAdapter
            mAdapter?.notifyDataSetChanged()
        } else {
            mAdapter?.setDataset(topArtists)
        }
    }

    var onArtistclickedListener = View.OnClickListener { view ->
        val position = rclr_artists?.getChildLayoutPosition(view)
        val artist = mAdapter?.getItemByPosition(position!!)
        val intent = Intent(context, DetailsActivity::class.java)
        intent.putExtra("name", artist?.name)
        intent.putExtra("image", artist?.imageUrl)
        intent.putExtra("playCount", artist?.playcount)
        intent.putExtra("artist", "")
        intent.putExtra("duration", "")
        startActivity(intent)
    }

    override fun showError() {
        Toast.makeText(context, R.string.general_error, Toast.LENGTH_SHORT).show()
    }

    override fun showEmpty() {
        empty_layout?.visibility = View.VISIBLE
    }

    override fun hidEmpty() {
        empty_layout?.visibility = View.GONE
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnFragmentInteractionListener {
        fun onArtistClicked(artist: Artist)
    }

    companion object {
        fun newInstance(): TopArtistsFragment {
            return TopArtistsFragment()
        }
    }
}