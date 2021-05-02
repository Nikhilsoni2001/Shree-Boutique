package com.SB.shreeboutique.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.SB.shreeboutique.R
import com.SB.shreeboutique.adapters.ViewPagerAdapter
import com.google.android.material.button.MaterialButton
import com.google.android.material.tabs.TabLayout

class CustomersFragment : Fragment(R.layout.fragment_customers) {

    lateinit var et_name: EditText
    lateinit var et_contactNo: EditText
    lateinit var et_AlternativeContactNo: EditText
    lateinit var btn_next: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customers, container, false)
        initialization(view)

        btn_next.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_customer, CustomerTopFragment()).commit()
        }
        return view
    }

    private fun initialization(view: View) {
        et_name = view.findViewById(R.id.et_name)
        et_contactNo = view.findViewById(R.id.et_contactNo)
        et_AlternativeContactNo = view.findViewById(R.id.et_AlternativeContactNo)
        btn_next = view.findViewById(R.id.btn_next)
    }


}