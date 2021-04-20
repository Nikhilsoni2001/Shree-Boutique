package com.SB.shreeboutique.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.datepicker.MaterialDatePicker


class NewemployeeFragment : Fragment(R.layout.fragment_newemployee) {
    private lateinit var datepicker : MaterialButton
    private lateinit var Date : TextView


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_newemployee, container, false)
        var date = ""
        datepicker= view.findViewById(R.id.ib_datePicker2)
        Date = view.findViewById(R.id.tv_Date)

        datepicker.setOnClickListener {
            val materialDatePicker = buildMaterialDatePicker()
            materialDatePicker.show(parentFragmentManager,"Date Picker")
            materialDatePicker.addOnPositiveButtonClickListener {
                date = materialDatePicker.headerText
                Date.text = materialDatePicker.headerText
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