package com.SB.shreeboutique.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.SB.shreeboutique.R
import com.SB.shreeboutique.fragment.CustomerListFragment

class Customer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_customer)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container_customer, CustomerListFragment()).commit()
    }

}