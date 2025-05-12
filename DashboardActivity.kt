package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.budgettracker.AddExpensesActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val btnAddExpenses: Button = findViewById(R.id.btnAddExpenses)
        val btnAddSetGoal: Button = findViewById(R.id.btnSetGoal)
        val btnExpenses: Button = findViewById(R.id.btnExpenses)
        val btnTrends: Button = findViewById(R.id.btnTrends)
        val btnRewards: Button = findViewById(R.id.btnRewards)

        btnAddExpenses.setOnClickListener {
            startActivity(Intent(this, AddExpensesActivity::class.java))
        }

        btnAddSetGoal.setOnClickListener{
            startActivity(Intent(this, SetGoalActivity::class.java))
        }

        btnExpenses.setOnClickListener {
            startActivity(Intent(this, ExpensesActivity::class.java))
        }

        btnTrends.setOnClickListener {
            startActivity(Intent(this, TrendsActivity::class.java))
        }

        btnRewards.setOnClickListener {
            startActivity(Intent(this, RewardActivity::class.java))
        }
    }
}