package com.example.artist.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.artist.R
import com.example.artist.models.Album
import com.example.artist.utils.ImageLoader
import kotlinx.android.synthetic.main.album_item.view.*

open class TopAlbumsAdapter(private var mDataset: MutableList<Album>, private var mContext: Context, var mOnItemClickListener: View.OnClickListener?) : RecyclerView.Adapter<TopAlbumsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.album_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mDataset[position]
        holder.albumImageView.let { ImageLoader.loadImage(mContext, item.imageUrl, R.drawable.default_album, it) }
        holder.nameTextView.text = item.name
        holder.playCountTextView.text = ""
        holder.artistTextView.text = item.artist
    }

    override fun getItemCount(): Int {
        return mDataset.size
    }

    fun setDataset(items: MutableList<Album>) {
        mDataset = items
        notifyDataSetChanged()
    }

    fun getItemByPosition(position: Int): Album {
        return mDataset[position]
    }

    fun clearDataset() {
        mDataset.clear()
        notifyDataSetChanged()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {
            itemView.setOnClickListener { view ->
                onItemClicked(view)
            }
        }

        var albumImageView: ImageView = itemView.img_album

        var artistTextView: TextView = itemView.txt_album_artist

        var nameTextView: TextView = itemView.txt_album_name

        var playCountTextView: TextView = itemView.txt_plays

        private fun onItemClicked(view: View) {
            if (itemView.hasOnClickListeners()) {
                mOnItemClickListener?.onClick(view)
            }
        }
    }

}