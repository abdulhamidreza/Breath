package com.interview.breath.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.interview.breath.R
import com.interview.breath.databinding.ActivityNewDocBinding
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class NewDocActivity : AppCompatActivity() {

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_doc)


        val springDotsIndicator = findViewById<WormDotsIndicator>(R.id.spring_dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val adapter = ViewAdapter(this)
        viewPager.adapter = adapter
        springDotsIndicator.setViewPager(viewPager)

    }

}