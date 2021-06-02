package com.SB.shreeboutique.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.SB.shreeboutique.R
import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    private val rotateOpen: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_open_anim) }
    private val rotateClose: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.rotate_close_anim) }
    private val fromBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.from_bottom_anim) }
    private val toBottom: Animation by lazy { AnimationUtils.loadAnimation(this, R.anim.to_bottom_anim) }
    private lateinit var btnCustomers: MaterialButton
    private lateinit var btnBookings: MaterialButton
    private lateinit var btnEmployees: MaterialButton
    private lateinit var add_customer_fab: FloatingActionButton
    private lateinit var create_booking_fab: FloatingActionButton
    private lateinit var expanded_fab: FloatingActionButton
    private var clicked = false

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

        expanded_fab.setOnClickListener{
           onExpandedButtonClicked()
        }

        add_customer_fab.setOnClickListener{
            Toast.makeText(this,"Add Customer FAB Clicked", Toast.LENGTH_SHORT).show()
        }

        create_booking_fab.setOnClickListener{
            Toast.makeText(this,"Create Booking FAB Clicked", Toast.LENGTH_SHORT).show()
        }

    }

    private fun onExpandedButtonClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        setClickable(clicked)
        clicked = !clicked


    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked){
            create_booking_fab.visibility = View.VISIBLE
            add_customer_fab.visibility = View.VISIBLE
        }else {
            create_booking_fab.visibility = View.INVISIBLE
            add_customer_fab.visibility = View.INVISIBLE
        }

    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked){
            create_booking_fab.startAnimation(fromBottom)
            add_customer_fab.startAnimation(fromBottom)
            expanded_fab.startAnimation(rotateOpen)
        }else{
            create_booking_fab.startAnimation(toBottom)
            add_customer_fab.startAnimation(toBottom)
            expanded_fab.startAnimation(rotateClose)
        }
    }

    private fun setClickable(clicked: Boolean){
        if(!clicked){
            create_booking_fab.isClickable = true
            add_customer_fab.isClickable = true
        }else {
            create_booking_fab.isClickable = false
            add_customer_fab.isClickable = false
        }

    }

    private fun initializing() {

        btnCustomers = findViewById(R.id.btnCustomers)
        btnBookings = findViewById(R.id.btnBookings)
        btnEmployees = findViewById(R.id.btnEmployees)
        add_customer_fab = findViewById(R.id.add_customer_fab)
        create_booking_fab = findViewById(R.id.create_booking_fab)
        expanded_fab = findViewById(R.id.expanded_fab)

    }
}