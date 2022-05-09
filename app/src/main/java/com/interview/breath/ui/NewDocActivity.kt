package com.interview.breath.ui

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.interview.breath.R
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class NewDocActivity : AppCompatActivity() {

    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var recyclerAdapter: RecyclerAdapter? = null

    private var recyclerViewP: RecyclerView? = null
    private var linearLayoutManagerP: LinearLayoutManager? = null
    private var recyclerAdapterP: RecyclerAdapter? = null

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_doc)

        //View Pager
        val springDotsIndicator = findViewById<WormDotsIndicator>(R.id.spring_dots_indicator)
        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val adapter = ViewPagerAdapter(this)
        viewPager.adapter = adapter
        springDotsIndicator.setViewPager(viewPager)


        //Middle Recycler View
        recyclerView = findViewById<View>(R.id.rv_design) as RecyclerView
        linearLayoutManager = LinearLayoutManager(applicationContext, LinearLayoutManager.HORIZONTAL, false)
        recyclerView!!.layoutManager = linearLayoutManager
        recyclerAdapter = RecyclerAdapter(this@NewDocActivity)
        recyclerView!!.adapter = recyclerAdapter


        //Persent Recycler View
        recyclerViewP = findViewById<View>(R.id.rv_design_present) as RecyclerView
        linearLayoutManagerP = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerViewP!!.layoutManager = linearLayoutManagerP
        recyclerAdapterP = RecyclerAdapter(this@NewDocActivity)
        recyclerViewP!!.adapter = recyclerAdapterP
    }

}