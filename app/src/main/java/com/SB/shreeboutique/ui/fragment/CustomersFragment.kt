package com.SB.shreeboutique.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class CustomersFragment : Fragment(R.layout.fragment_customers) {

    private lateinit var el_name: TextInputLayout
    private lateinit var et_name: TextInputEditText
    private lateinit var el_contact: TextInputLayout
    private lateinit var et_contact: TextInputEditText
    private lateinit var el_AlternativeContact: TextInputLayout
    private lateinit var et_AlternativeContact: TextInputEditText
    private lateinit var btn_next: MaterialButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_customers, container, false)
        initialization(view)

        btn_next.setOnClickListener {

            if (et_name.text.toString().isNotEmpty()) {
                if (et_contact.text.toString().isNotEmpty()) {
                    parentFragmentManager.beginTransaction()
                        .replace(R.id.container_customer, CustomerTopFragment()).commit()
                } else {
                    el_contact.error = "Please Enter a valid Contact"
                }
            } else {
                el_name.error = "Please Enter a valid Name"
            }


        }
        return view
    }

    private fun initialization(view: View) {
        el_name = view.findViewById(R.id.el_name)
        et_name = view.findViewById(R.id.et_name)
        el_contact = view.findViewById(R.id.el_contact)
        et_contact = view.findViewById(R.id.et_contact)
        el_AlternativeContact = view.findViewById(R.id.el_AlternativeContactNo)
        et_AlternativeContact = view.findViewById(R.id.et_AlternativeContactNo)
        btn_next = view.findViewById(R.id.btn_next)
    }


}