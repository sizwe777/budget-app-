package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class ExpensesActivity : AppCompatActivity() {

    private lateinit var adapter: ExpensesAdapter
    private lateinit var recyclerExpenses: RecyclerView

    private lateinit var btnSaveExpenses: Button
    private lateinit var inputAmount: EditText
    private lateinit var inputCategory: EditText
    private lateinit var inputDate: EditText
    private lateinit var inputDesc: EditText
    private lateinit var inputEnd: EditText
    private lateinit var inputStart: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expenses)

        // Initialize views
        recyclerExpenses = findViewById(R.id.recyclerExpenses)
        btnSaveExpenses = findViewById(R.id.btnSaveExpenses)
        inputAmount = findViewById(R.id.inputAmount)
        inputCategory = findViewById(R.id.inputCategory)
        inputDate = findViewById(R.id.inputDate)
        inputDesc = findViewById(R.id.inputDesc)
        inputEnd = findViewById(R.id.inputEnd)
        inputStart = findViewById(R.id.inputStart)

        // Setup RecyclerView
        adapter = ExpensesAdapter(emptyList())
        recyclerExpenses.layoutManager = LinearLayoutManager(this)
        recyclerExpenses.adapter = adapter

        // Database access
        val dao = AppDatabase.getDatabase(this).expenseDao()

        // Load expenses from DB
        lifecycleScope.launch {
            dao.getAllExpenses().collect { expensesList ->
                adapter.updateData(expensesList)
            }
        }

        // Save button listener
        btnSaveExpenses.setOnClickListener {
            val date = inputDate.text.toString()
            val startTime = inputStart.text.toString()
            val endTime = inputEnd.text.toString()
            val desc = inputDesc.text.toString()
            val category = inputCategory.text.toString()
            val amount = inputAmount.text.toString().toDoubleOrNull()

            if (date.isBlank() || startTime.isBlank() || endTime.isBlank() ||
                desc.isBlank() || category.isBlank() || amount == null
            ) {
                Toast.makeText(this, "Please fill all fields correctly", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val newExpense = Expenses(
                id = 0,
                date = date,
                startTime = startTime,
                endTime = endTime,
                description = desc,
                category = category,
                amount = amount
            )

            lifecycleScope.launch {
                dao.insert(newExpense)
                Toast.makeText(this@ExpensesActivity, "Saved successfully", Toast.LENGTH_SHORT).show()
            }
        }
    }
}