package com.SB.shreeboutique.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable


@Entity(tableName = "employee")
data class Employee(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val position: String,
    val salary: Int,
    val dateOfJoining: String
) : Serializable