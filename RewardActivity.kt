package com.example.budgettrackerapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RewardActivity : AppCompatActivity () {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_reward)

        val textView = findViewById<TextView>(R.id.textReward)
        textView.text = "Reward achievements will show up here"
    }
}