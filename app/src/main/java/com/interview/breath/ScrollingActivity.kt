package com.interview.breath

import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.interview.breath.databinding.ActivityScrollingBinding
import com.interview.breath.ui.RecyclerMiddleAdapter
import com.interview.breath.ui.RecyclerPeresetAdapter
import com.interview.breath.ui.ViewPagerAdapter
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding

    private var recyclerView: RecyclerView? = null
    private var linearLayoutManager: LinearLayoutManager? = null
    private var recyclerAdapter: RecyclerMiddleAdapter? = null

    private var recyclerViewP: RecyclerView? = null
    private var linearLayoutManagerP: LinearLayoutManager? = null
    private var recyclerAdapterP: RecyclerPeresetAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = "About the Program"

        binding.toolbarLayout.collapsedTitleGravity = Gravity.CENTER
        binding.toolbarLayout.setExpandedTitleColor(getColor(R.color.black))
        binding.toolbarLayout.setCollapsedTitleTextColor(getColor(R.color.black))


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
        recyclerAdapter = RecyclerMiddleAdapter(this@ScrollingActivity)
        recyclerView!!.adapter = recyclerAdapter


        //Persent Recycler View
        recyclerViewP = findViewById<View>(R.id.rv_design_present) as RecyclerView
        linearLayoutManagerP = LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        recyclerViewP!!.layoutManager = linearLayoutManagerP
        recyclerAdapterP = RecyclerPeresetAdapter(this@ScrollingActivity)
        recyclerViewP!!.adapter = recyclerAdapterP


    }
}