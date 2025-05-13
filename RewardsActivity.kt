package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R

class RewardsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rewards)

        val rewardsView = findViewById<TextView>(R.id.rewardsText)
        rewardsView.text = "You saved money this month! 🏆"
    }
}