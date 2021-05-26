package com.SB.shreeboutique.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.SB.shreeboutique.db.Employee
import com.SB.shreeboutique.repositories.EmployeesRepository
import kotlinx.coroutines.launch

class MainViewModel(private val repository: EmployeesRepository) : ViewModel() {
    fun insert(employee: Employee) = viewModelScope.launch { repository.insert(employee) }
    fun delete(employee: Employee) = viewModelScope.launch { repository.delete(employee) }
    fun update(employee: Employee) = viewModelScope.launch { repository.update(employee) }
    fun getAllEmployees() = repository.getAllEmployees()
}