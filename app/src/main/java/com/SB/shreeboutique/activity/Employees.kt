package com.SB.shreeboutique.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.SB.shreeboutique.R
import com.SB.shreeboutique.fragm.EmployeeFragment
import com.SB.shreeboutique.fragment.BookingsFragment

class Employees : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)
        supportFragmentManager.beginTransaction()
            .replace(R.id.employee_container, EmployeeFragment()).commit()
    }
}