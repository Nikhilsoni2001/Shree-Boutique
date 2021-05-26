package com.SB.shreeboutique.repositories

import com.SB.shreeboutique.db.Employee
import com.SB.shreeboutique.db.ShreeDatabase

class EmployeesRepository(private val db: ShreeDatabase) {
    suspend fun insert(employee: Employee) = db.employeesDao().insert(employee)
    suspend fun delete(employee: Employee) = db.employeesDao().delete(employee)
    suspend fun update(employee: Employee) = db.employeesDao().update(employee)
    fun getAllEmployees() = db.employeesDao().getAllEmployees()
}