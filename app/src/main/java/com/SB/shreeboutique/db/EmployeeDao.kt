package com.SB.shreeboutique.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface EmployeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(employee: Employee)

    @Delete
    suspend fun delete(employee: Employee)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(employee: Employee)

    @Query("SELECT * FROM employee")
    fun getAllEmployees(): LiveData<List<Employee>>
}