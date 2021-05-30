package com.SB.shreeboutique.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.SB.shreeboutique.R
import com.SB.shreeboutique.ui.fragment.bookings.BookingsFragment

class Booking : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)
        supportFragmentManager.beginTransaction()
            .replace(R.id.booking_container, BookingsFragment()).commit()
    }
}