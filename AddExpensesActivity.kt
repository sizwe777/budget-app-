package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R
import java.text.SimpleDateFormat
import java.util.*

class AddExpensesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expenses)

        val description = findViewById<EditText>(R.id.descriptionInput)
        val amount = findViewById<EditText>(R.id.amountInput)
        val category = findViewById<Spinner>(R.id.categorySpinner)
        val btnSave = findViewById<Button>(R.id.btnSave)

        btnSave.setOnClickListener {
            if (description.text.isNotEmpty() && amount.text.isNotEmpty()) {
                Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}