package com.SB.shreeboutique.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.SB.shreeboutique.R
import com.google.android.material.floatingactionbutton.FloatingActionButton


class BookingsFragment : Fragment(R.layout.fragment_bookings) {
    lateinit var fabBooking : FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_bookings,container,false)
        initialization(view)

        fabBooking.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.booking_container,  BookingsAddFragment()).commit()
        }
        return view

    }
   private fun initialization(view: View){
        fabBooking = view.findViewById(R.id.fab_add_booking)
    }
}