package com.SB.shreeboutique.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.SB.shreeboutique.R
import com.SB.shreeboutique.db.ShreeDatabase
import com.SB.shreeboutique.fragm.EmployeeFragment
import com.SB.shreeboutique.repositories.EmployeesRepository
import com.SB.shreeboutique.ui.viewmodels.MainViewModel
import com.SB.shreeboutique.ui.viewmodels.MainViewModelFactory

class Employees : AppCompatActivity() {
    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employees)

        val database = ShreeDatabase(this)
        val repository = EmployeesRepository(database)
        val factory = MainViewModelFactory(this, repository)
        viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)

        supportFragmentManager.beginTransaction()
            .replace(R.id.employee_container, EmployeeFragment()).commit()
    }
}