package com.example.budgettrackerapp

@Entity(tableName = "expenses")
data class Expenses(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val date: String,
    val startTime: String,
    val endTime: String,
    val description: String,
    val category: String,
    val amount: Double
)