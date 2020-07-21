package com.example.artist.ui.toptrackslisting

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.artist.R
import com.example.artist.adapters.TopTracksAdapter
import com.example.artist.models.Track
import com.example.artist.ui.BaseFragment
import com.example.artist.ui.DetailsActivity
import com.example.artist.ui.toptrackslisting.di.DaggerTopTracksComponent
import com.example.artist.ui.toptrackslisting.di.TopTracksModule
import com.example.artist.utils.Constants
import kotlinx.android.synthetic.main.fragment_top_tracks.*
import javax.inject.Inject

class TopTracksFragment : BaseFragment(), TopTracksView {
    private var mListener: OnFragmentInteractionListener? = null

    @Inject
    lateinit var mPresenter: TopTracksPresenter

    private var mAdapter: TopTracksAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DaggerTopTracksComponent.builder().topTracksModule(TopTracksModule(this)).build().inject(this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        mPresenter.getTopTracks(Constants.DEFAULT_LASTFM_USER, Constants.API_KEY)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_top_tracks, container, false)
        return view
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

    override fun showError() {
        Toast.makeText(context, R.string.general_error, Toast.LENGTH_SHORT).show()
    }

    override fun updateData(tracks: MutableList<Track>) {
        if (mAdapter == null) {
            mAdapter = context?.let { TopTracksAdapter(tracks, it, onTrackClickedListener) }
            val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            rclr_tracks?.layoutManager = linearLayoutManager
            rclr_tracks?.adapter = mAdapter
            mAdapter?.notifyDataSetChanged()
        } else {
            mAdapter?.setDataset(tracks)
        }
    }

    override fun showEmpty() {
        empty_layout?.visibility = View.VISIBLE
    }

    override fun hidEmpty() {
        empty_layout?.visibility = View.GONE
    }

    override fun searchUserName(userName: String) {
        mAdapter?.clearDataset()
        mPresenter.getTopTracks(userName, Constants.API_KEY)
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     */
    interface OnFragmentInteractionListener {
        fun onTrackClicked(track: Track)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.onDestroy()
    }

    private var onTrackClickedListener = View.OnClickListener { view ->
        if (mListener != null) {
            val position = rclr_tracks?.getChildAdapterPosition(view)
            val track = position?.let { mAdapter?.getItemAt(it) }
            val intent = Intent(context, DetailsActivity::class.java)
            intent.putExtra("name", track?.name)
            intent.putExtra("image", track?.imageUrl)
            intent.putExtra("playCount", track?.playcount)
            intent.putExtra("artist", track?.artist)
            intent.putExtra("duration", "")
            startActivity(intent)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         */
        fun newInstance(): TopTracksFragment {
            return TopTracksFragment()
        }
    }
}