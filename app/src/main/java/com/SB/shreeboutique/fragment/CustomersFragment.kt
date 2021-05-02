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

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customers, container, false)
        return view
    }


}