package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.trackerapp.R

class ExpensesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        // RecyclerView Setup
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerExpenses)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // You can set dummy data or fetch from RoomDB here
        // recyclerView.adapter = ExpensesAdapter(getExpensesList())

        // Add Expense Button Setup
        val addExpenseButton = findViewById<Button>(R.id.addExpenseButton)
        addExpenseButton.setOnClickListener {
            val intent = Intent(this, AddExpensesActivity::class.java)
            startActivity(intent)
        }
    }
}