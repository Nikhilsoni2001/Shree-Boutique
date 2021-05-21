package com.SB.shreeboutique.fragm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.SB.shreeboutique.fragment.NewemployeeFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class EmployeeFragment : Fragment(R.layout.fragment_employee) {
    lateinit var fabEmployee : FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_employee,container,false)
        initialization(view)

        fabEmployee.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.employee_container,  NewemployeeFragment()).commit()
        }
        return view

    }
    private fun initialization(view: View){
        fabEmployee = view.findViewById(R.id.fab_add_employee)
    }
}