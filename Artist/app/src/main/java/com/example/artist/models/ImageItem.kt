package com.example.artist.models

import com.google.gson.annotations.SerializedName

data class ImageItem(@SerializedName("#text")
                     var url: String,

                     @SerializedName("size")
                     var size: String)