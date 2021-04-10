package com.SB.shreeboutique.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.SB.shreeboutique.R
import com.SB.shreeboutique.adapters.ViewPagerAdapter
import com.SB.shreeboutique.fragment.CustomerFragment1
import com.SB.shreeboutique.fragment.CustomerFragment2
import com.google.android.material.tabs.TabLayout

class Customer : AppCompatActivity() {
    lateinit var viewPager : ViewPager
    lateinit var tabs : TabLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)
        initialize()
        setUpTabs()
    }

    private fun initialize() {
        viewPager = findViewById(R.id.viewPager)
        tabs = findViewById(R.id.tabs)
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(CustomerFragment1(), "Customer1")
        adapter.addFragment(CustomerFragment2(), "Customer2")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_add_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_add_24)
    }
}