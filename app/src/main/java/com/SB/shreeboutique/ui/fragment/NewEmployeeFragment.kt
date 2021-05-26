package com.SB.shreeboutique.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.SB.shreeboutique.db.Employee
import com.SB.shreeboutique.fragm.EmployeeFragment
import com.SB.shreeboutique.ui.activity.Employees
import com.SB.shreeboutique.ui.viewmodels.MainViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker


class NewEmployeeFragment : Fragment() {

    private lateinit var et_name: EditText
    private lateinit var btn_addEmployee: MaterialButton
    private lateinit var et_position: EditText
    private lateinit var et_salary: EditText
    private lateinit var datepicker: MaterialButton
    private lateinit var Date: TextView
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newemployee, container, false)
        var date = ""
        et_name = view.findViewById(R.id.et_name)
        et_position = view.findViewById(R.id.et_position)
        et_salary = view.findViewById(R.id.et_salary)
        datepicker = view.findViewById(R.id.btn_datePicker)
        Date = view.findViewById(R.id.tv_Date)
        btn_addEmployee = view.findViewById(R.id.btn_addEmployee)
        viewModel = (activity as Employees).viewModel

        datepicker.setOnClickListener {
            val materialDatePicker = buildMaterialDatePicker()
            materialDatePicker.show(parentFragmentManager, "Date Picker")
            materialDatePicker.addOnPositiveButtonClickListener {
                date = materialDatePicker.headerText
                Date.text = materialDatePicker.headerText
            }
        }

        btn_addEmployee.setOnClickListener {
            val name = et_name.text.trim().toString()
            val position = et_position.text.trim().toString()
            val salary = et_salary.text.trim().toString()
            if (name.isNotEmpty()) {
                if (date.isNotEmpty()) {
                    if (position.isNotEmpty()) {
                        if (salary.isNotEmpty()) {
                            val employee = Employee(0, name, position, salary.toInt(), date)
                            viewModel.insert(employee)
                            parentFragmentManager.beginTransaction()
                                .replace(R.id.employee_container, EmployeeFragment()).commit()
                        } else {
                            et_salary.error = "Please enter a salary!!"
                        }
                    } else {
                        et_position.error = "Please enter a position!!"
                    }
                }
            } else {
                et_name.error = "Please Enter a valid Name!"
            }
        }

        return view
    }
}

private fun buildMaterialDatePicker(): MaterialDatePicker<Long> {
    val builder = MaterialDatePicker.Builder.datePicker()
    builder.setTitleText("Date of Joining")
    return builder.build()

}