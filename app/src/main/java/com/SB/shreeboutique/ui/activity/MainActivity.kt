package com.SB.shreeboutique.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    private lateinit var btnCustomers: MaterialButton
    private lateinit var btnBookings: MaterialButton
    private lateinit var btnEmployees: MaterialButton



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializing()

        btnCustomers.setOnClickListener {
            startActivity(Intent(this@MainActivity, Customer::class.java))
        }

        btnBookings.setOnClickListener {
            startActivity(Intent(this@MainActivity, Booking::class.java))
        }

        btnEmployees.setOnClickListener {
            startActivity(Intent(this@MainActivity, Employees::class.java))
        }
    }

    private fun initializing() {
        btnCustomers = findViewById(R.id.btnCustomers)
        btnBookings = findViewById(R.id.btnBookings)
        btnEmployees = findViewById(R.id.btnEmployees)
    }
}