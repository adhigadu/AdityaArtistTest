package com.example.artist.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.artist.BuildConfig
import com.example.artist.R
import com.example.artist.utils.DurationConverter
import com.example.artist.utils.ImageLoader.loadImage
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {
    var bundle: Bundle? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        bundle = intent.extras
        if (BuildConfig.DEBUG && bundle == null) {
            error("Assertion failed")
        }

        if (bundle?.getString("image") != "") {
            loadImage(this, bundle?.getString("image"), R.drawable.default_track, img_track)
        }
        txt_track_name.text = bundle?.getString("name")
        txt_track_artist.text = bundle?.getString("artist")
        txt_plays.text = bundle?.getString("playCount")
        if (bundle?.getString("duration") != "") {
            try {
                txt_duration.text = bundle?.getString("duration")?.toLong()?.let { DurationConverter.getDurationInMinutesText(it) } + " Minutes"
            } catch (ignored: Exception) {
            }
        }
    }
}