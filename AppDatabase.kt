package com.example.budgettrackerapp

import android.content.Context


@Database(entities = [Expenses::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "budget_tracker_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}

private fun Any.build(): AppDatabase {

    return TODO("Provide the return value")
}

