package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R

class SignupActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val signupButton =
            findViewById<Button>(R.id.signupButton)  // Assuming you have a signup button
        signupButton.setOnClickListener {
            // Perform signup logic here (e.g., saving data, authentication)

            // Navigate to DashboardActivity
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()

            val username = findViewById<EditText>(R.id.editTextUsername)
            val password = findViewById<EditText>(R.id.editTextPassword)

            findViewById<Button>(R.id.buttonSignup).setOnClickListener {
                if (username.text.isNotEmpty() && password.text.isNotEmpty()) {
                    Toast.makeText(this, "Signup successful", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}