package com.example.artist

import androidx.test.InstrumentationRegistry
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

/**
 * Created by Bassem Samy on 6/17/2017.
 * Helper class that reads a file in the test assets directory into a string
 */
object AssetsFileReader {
    @JvmStatic
    @Throws(IOException::class)
    fun readFileAsString(fileName: String?): String {
        val inputStream = InstrumentationRegistry.getContext().assets.open(fileName!!)
        val reader = BufferedReader(InputStreamReader(inputStream))
        val builder = StringBuilder()
        var line: String? = null
        while (reader.readLine().also { line = it } != null) {
            builder.append(line)
        }
        reader.close()
        return builder.toString()
    }
}