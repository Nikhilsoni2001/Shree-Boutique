package com.SB.shreeboutique.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.SB.shreeboutique.R
import com.SB.shreeboutique.fragment.BookingsAddFragment
import com.SB.shreeboutique.fragment.BookingsFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Booking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        supportFragmentManager.beginTransaction()
            .replace(R.id.booking_container, BookingsFragment()).commit()

    }
}