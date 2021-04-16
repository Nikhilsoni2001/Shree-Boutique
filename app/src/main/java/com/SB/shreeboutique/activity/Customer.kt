package com.SB.shreeboutique.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.SB.shreeboutique.R
import com.SB.shreeboutique.adapters.ViewPagerAdapter
import com.SB.shreeboutique.fragment.CustomerFragment1
import com.SB.shreeboutique.fragment.CustomerFragment2
import com.SB.shreeboutique.fragment.CustomerListFragment
import com.SB.shreeboutique.fragment.CustomersFragment
import com.google.android.material.tabs.TabLayout

class Customer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_customer, CustomerListFragment()).commit()
    }

}