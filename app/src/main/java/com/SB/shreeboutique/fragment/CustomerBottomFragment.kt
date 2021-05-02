package com.SB.shreeboutique.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton

class CustomerBottomFragment : Fragment() {

    lateinit var btn_save: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customer_bottom, container, false)
        initialization(view)

        btn_save.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.container_customer, CustomerListFragment()).commit()
        }
        return view
    }

    private fun initialization(view: View) {
        btn_save = view.findViewById(R.id.btn_save)
    }
}