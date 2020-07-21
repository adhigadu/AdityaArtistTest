package com.example.artist

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import org.hamcrest.Matcher
import org.hamcrest.Matchers
import org.junit.Assert

class RecyclerViewItemsCountAssertion(expectedCount: Int) : ViewAssertion {
    private val mMatcher: Matcher<Int>
    override fun check(view: View, noViewFoundException: NoMatchingViewException) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }
        val recyclerView = view as RecyclerView
        val adapter = recyclerView.adapter!!
        Assert.assertTrue(mMatcher.matches(adapter.itemCount))
    }

    init {
        mMatcher = Matchers.`is`(expectedCount)
    }
}