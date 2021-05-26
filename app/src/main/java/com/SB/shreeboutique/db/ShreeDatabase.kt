package com.SB.shreeboutique.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Employee::class], version = 1, exportSchema = false)
abstract class ShreeDatabase : RoomDatabase() {
    abstract fun employeesDao(): EmployeeDao

    companion object {
        @Volatile
        private var instance: ShreeDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also {
                instance = it
            }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(context, ShreeDatabase::class.java, "ShreeDB")
                .fallbackToDestructiveMigration().build()
    }
}