package com.example.budgettrackerapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R

class SetGoalActivity : AppCompatActivity() {

    private lateinit var minGoalInput: EditText
    private lateinit var maxGoalSeekBar: SeekBar
    private lateinit var maxGoalValue: TextView
    private lateinit var saveGoalBtn: Button

    private var maxGoal = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_goal)

        minGoalInput = findViewById(R.id.minGoalInput)
        maxGoalSeekBar = findViewById(R.id.maxGoalSeekBar)
        maxGoalValue = findViewById(R.id.maxGoalValue)
        saveGoalBtn = findViewById(R.id.saveGoalBtn)

        maxGoalSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                maxGoal = progress
                maxGoalValue.text = "Max Goal: $$progress"
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }
        })

        saveGoalBtn.setOnClickListener {
            val minGoalStr = minGoalInput.text.toString()
            if (minGoalStr.isEmpty()) {
                Toast.makeText(this, "Please enter a minimum goal", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val minGoal = minGoalStr.toInt()
            // TODO: Save minGoal and maxGoal to RoomDB or shared preferences
            Toast.makeText(this, "Goal Saved", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}