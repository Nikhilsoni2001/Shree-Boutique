package com.SB.shreeboutique.ui.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.SB.shreeboutique.repositories.EmployeesRepository

class MainViewModelFactory(
    private val context: Context,
    private val repository: EmployeesRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}