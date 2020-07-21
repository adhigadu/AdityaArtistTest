package com.example.artist.adapters

import android.content.Context
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.artist.R
import com.example.artist.ui.topalbumslisting.TopAlbumsFragment
import com.example.artist.ui.topartistslisting.TopArtistsFragment
import com.example.artist.ui.toptrackslisting.TopTracksFragment
import java.lang.ref.WeakReference
import java.util.*

open class MainPagerAdapter(fm: FragmentManager?, context: Context) : FragmentPagerAdapter(fm!!) {
    private var topArtistsTitle: String = context.getString(R.string.top_artists_title)
    private val topTracksTitle: String = context.getString(R.string.top_tracks_title)
    private val topAlbumsTitle: String = context.getString(R.string.top_albums_title)
    private var fragments: Hashtable<Int, WeakReference<Fragment>> = Hashtable()
    override fun getItem(position: Int): Fragment {
        return when (position) {
            TOP_ARTISTS_INDEX -> {
                val fr: Fragment = TopArtistsFragment.newInstance()
                fragments[position] = WeakReference(fr)
                fr
            }
            TOP_ALBUMS_INDEX -> {
                val fr: Fragment = TopAlbumsFragment.newInstance()
                fragments[position] = WeakReference(fr)
                fr
            }
            TOP_TRACKS_INDEX -> {
                val fr: Fragment = TopTracksFragment.newInstance()
                fragments[position] = WeakReference(fr)
                fr
            }
            else -> {
                TopArtistsFragment()
            }
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            TOP_ARTISTS_INDEX -> {
                topArtistsTitle
            }
            TOP_ALBUMS_INDEX -> {
                topAlbumsTitle
            }
            TOP_TRACKS_INDEX -> {
                topTracksTitle
            }
            else -> {
                super.getPageTitle(position)
            }
        }
    }

    override fun getCount(): Int {
        return NUMBER_OF_ITEMS
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        super.destroyItem(container, position, `object`)
        fragments.remove(position)
    }

    fun getFragments(): ArrayList<Fragment?> {
        val list = ArrayList<Fragment?>()
        for (i in 0 until fragments.size) {
            list.add(fragments[i]?.get())
        }
        return list
    }

    companion object {
        private const val NUMBER_OF_ITEMS = 3
        private const val TOP_ARTISTS_INDEX = 2
        private const val TOP_ALBUMS_INDEX = 0
        private const val TOP_TRACKS_INDEX = 1
    }

}