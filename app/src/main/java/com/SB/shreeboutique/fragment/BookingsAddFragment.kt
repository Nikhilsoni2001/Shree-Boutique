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


class BookingsAddFragment : Fragment(R.layout.fragment_bookingsadd) {
private lateinit var datepicker : MaterialButton
private lateinit var tvdeliveryDate :TextView
private lateinit var imageButton: ImageButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookingsadd, container, false)
       var date = ""
        datepicker= view.findViewById(R.id.ib_datePicker)
       tvdeliveryDate = view.findViewById(R.id.tv_Dateofdelivery)
        imageButton = view.findViewById(R.id.ib_booking)
        datepicker.setOnClickListener {
          val materialDatePicker = buildMaterialDatePicker()
            materialDatePicker.show(parentFragmentManager,"Date Picker")
            materialDatePicker.addOnPositiveButtonClickListener {
                date = materialDatePicker.headerText
                tvdeliveryDate.text = materialDatePicker.headerText
            }
        }

        imageButton.setOnClickListener {
            Intent(Intent.ACTION_GET_CONTENT).also {
                it.type = "image/*"
                startActivityForResult(it, 0)
            }
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK && requestCode == 0 ){
                val uri = data?.data
                imageButton.setImageURI(uri)

        }
    }
}

    private fun buildMaterialDatePicker(): MaterialDatePicker<Long> {
        val builder = MaterialDatePicker.Builder.datePicker()
        builder.setTitleText("Select Date of Delivery")
        return builder.build()

    }
