package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Signup Button (added to layout XML)
        val signupButton = findViewById<Button>(R.id.signupButton)
        signupButton.setOnClickListener {
            // Navigate to SignupActivity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // Navigation to other activities
        findViewById<Button>(R.id.btnAddExpenses).setOnClickListener {
            startActivity(Intent(this, AddExpensesActivity::class.java))
        }

        findViewById<Button>(R.id.btnExpenses).setOnClickListener {
            startActivity(Intent(this, ExpensesActivity::class.java))
        }

        findViewById<Button>(R.id.btnTrends).setOnClickListener {
            startActivity(Intent(this, TrendsActivity::class.java))
        }

        findViewById<Button>(R.id.btnRewards).setOnClickListener {
            startActivity(Intent(this, RewardsActivity::class.java))
        }

        findViewById<Button>(R.id.btnSetGoal).setOnClickListener {
            startActivity(Intent(this, SetGoalActivity::class.java))
        }
    }
}