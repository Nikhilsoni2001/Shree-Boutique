package com.SB.shreeboutique.ui.fragment.customers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CustomerListFragment : Fragment(R.layout.fragment_customer_list) {

    lateinit var fabNewCustomer: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customer_list, container, false)
        initialization(view)

        fabNewCustomer.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_customer, CustomersFragment()).commit()
        }

        return view
    }


    private fun initialization(view: View) {
        fabNewCustomer = view.findViewById(R.id.fabNewCustomers)
    }

}