package com.example.budgettracker

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.budgettrackerapp.R
import java.text.SimpleDateFormat
import java.util.*

class AddExpensesActivity : AppCompatActivity() {

    private lateinit var dateButton: Button
    private lateinit var startTimeButton: Button
    private lateinit var endTimeButton: Button
    private lateinit var imageView: ImageView
    private lateinit var categorySpinner: Spinner
    private lateinit var descriptionInput: EditText
    private lateinit var amountInput: EditText
    private lateinit var saveButton: Button

    private var selectedDate = ""
    private var startTime = ""
    private var endTime = ""

    private val IMAGE_REQUEST_CODE = 101
    private var expenseImage: Bitmap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expenses)

        dateButton = findViewById(R.id.btnDate)
        startTimeButton = findViewById(R.id.btnStartTime)
        endTimeButton = findViewById(R.id.btnEndTime)
        imageView = findViewById(R.id.expenseImage)
        categorySpinner = findViewById(R.id.categorySpinner)
        descriptionInput = findViewById(R.id.descriptionInput)
        amountInput = findViewById(R.id.amountInput)
        saveButton = findViewById(R.id.btnSave)

        categorySpinner.adapter = ArrayAdapter.createFromResource(
            this, R.array.expense_categories, android.R.layout.simple_spinner_dropdown_item
        )

        dateButton.setOnClickListener {
            val calendar = Calendar.getInstance()
            DatePickerDialog(this,
                { _, year, month, day ->
                    selectedDate = "$day/${month + 1}/$year"
                    dateButton.text = selectedDate
                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        startTimeButton.setOnClickListener {
            val c = Calendar.getInstance()
            TimePickerDialog(this,
                { _, hour, min ->
                    startTime = String.format("%02d:%02d", hour, min)
                    startTimeButton.text = startTime
                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true
            ).show()
        }

        endTimeButton.setOnClickListener {
            val c = Calendar.getInstance()
            TimePickerDialog(this,
                { _, hour, min ->
                    endTime = String.format("%02d:%02d", hour, min)
                    endTimeButton.text = endTime
                },
                c.get(Calendar.HOUR_OF_DAY),
                c.get(Calendar.MINUTE),
                true
            ).show()
        }

        imageView.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, IMAGE_REQUEST_CODE)
        }

        saveButton.setOnClickListener {
            val desc = descriptionInput.text.toString()
            val amt = amountInput.text.toString()
            val category = categorySpinner.selectedItem.toString()

            if (desc.isEmpty() || amt.isEmpty() || selectedDate.isEmpty() || startTime.isEmpty() || endTime.isEmpty()) {
                Toast.makeText(this, "Please fill all required fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // TODO: Save to RoomDB
            Toast.makeText(this, "Expense saved", Toast.LENGTH_SHORT).show()
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == IMAGE_REQUEST_CODE && resultCode == RESULT_OK) {
            expenseImage = data?.extras?.get("data") as Bitmap
            imageView.setImageBitmap(expenseImage)
        }
    }
}