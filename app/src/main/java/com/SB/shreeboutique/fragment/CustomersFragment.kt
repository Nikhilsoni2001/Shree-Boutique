package com.SB.shreeboutique.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.SB.shreeboutique.R
import com.SB.shreeboutique.adapters.ViewPagerAdapter
import com.google.android.material.tabs.TabLayout

class CustomersFragment : Fragment(R.layout.fragment_customers) {

    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customers, container, false)

        initialize(view)
        setUpTabs()

        return view
    }


    private fun initialize(view: View) {
        viewPager = view.findViewById(R.id.viewPager)
        tabs = view.findViewById(R.id.tabs)
    }

    private fun setUpTabs() {
        val adapter = ViewPagerAdapter(parentFragmentManager)
        adapter.addFragment(CustomerFragment1(), "Shirt/Kurti")
        adapter.addFragment(CustomerFragment2(), "Salwar/Plazo")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_baseline_add_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_baseline_add_24)
    }
}