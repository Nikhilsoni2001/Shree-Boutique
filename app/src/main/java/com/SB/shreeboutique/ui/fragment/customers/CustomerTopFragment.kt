package com.SB.shreeboutique.ui.fragment.customers

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton


class CustomerTopFragment : Fragment() {

    lateinit var btn_next: MaterialButton


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_customer_top, container, false)
        initialization(view)

        btn_next.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_customer, CustomerBottomFragment()).commit()
        }

        return view
    }

    private fun initialization(view: View) {
        btn_next = view.findViewById(R.id.btn_next)
    }

}