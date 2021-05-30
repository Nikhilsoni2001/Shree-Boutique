package com.SB.shreeboutique.ui.fragment.employees

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.SB.shreeboutique.R
import com.SB.shreeboutique.db.Employee
import com.SB.shreeboutique.ui.activity.Employees
import com.SB.shreeboutique.ui.viewmodels.MainViewModel
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker

class UpdateFragment : Fragment() {

    private lateinit var et_name: EditText
    private lateinit var btn_updateEmployee: MaterialButton
    private lateinit var et_position: EditText
    private lateinit var et_salary: EditText
    private lateinit var datepicker: MaterialButton
    private lateinit var Date: TextView
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_update, container, false)
        viewModel = (activity as Employees).viewModel
        val args: UpdateFragmentArgs by navArgs()

        var date = ""
        et_name = view.findViewById(R.id.et_name)
        et_position = view.findViewById(R.id.et_position)
        et_salary = view.findViewById(R.id.et_salary)
        datepicker = view.findViewById(R.id.btn_datePicker)
        Date = view.findViewById(R.id.tv_Date)
        btn_updateEmployee = view.findViewById(R.id.btn_updateEmployee)

        val employeeRef = args.employee
        val id = employeeRef.id
        val name = employeeRef.name
        val position = employeeRef.position
        val salary = employeeRef.salary
        val dateOfJoining = employeeRef.dateOfJoining

        et_name.setText(name)
        et_position.setText(position)
        et_salary.setText(salary)
        Date.text = dateOfJoining

        datepicker.setOnClickListener {
            val materialDatePicker = buildMaterialDatePicker()
            materialDatePicker.show(parentFragmentManager, "Date Picker")
            materialDatePicker.addOnPositiveButtonClickListener {
                date = materialDatePicker.headerText
                Date.text = materialDatePicker.headerText
            }
        }

        btn_updateEmployee.setOnClickListener {
            val name = et_name.text.trim().toString()
            val position = et_position.text.trim().toString()
            val salary = et_salary.text.trim().toString()
            if (name.isNotEmpty()) {
                if (date.isNotEmpty()) {
                    if (position.isNotEmpty()) {
                        if (salary.isNotEmpty()) {
                            val map = mutableMapOf<String, Any>()
                            map["name"] = name
                            map["position"] = position
                            map["salary"] = salary
                            map["dateOfJoining"] = date
                            val employee = Employee(id, name, position, salary.toInt(), date)
                            viewModel.update(employee)
                            Navigation.findNavController(view).navigate(R.id.employeeFragment)
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


    private fun buildMaterialDatePicker(): MaterialDatePicker<Long> {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Date of Joining")
        return builder.build()
    }
}
