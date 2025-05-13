package com.example.budgettrackerapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.trackerapp.R

class DashboardActivity {

}

class SignUpActivity {

}

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val signupButton = findViewById<Button>(R.id.signupButton)
        signupButton.setOnClickListener {
            // Navigate to the SignupActivity
            val intent = Intent(this, SignupActivity::class.java)
            startActivity(intent)
        }

        // Example: After successful login, navigate to the Dashboard
        val loginButton = findViewById<Button>(R.id.loginButton)
        loginButton.setOnClickListener {
            // Do login verification here (authentication logic)
            val intent = Intent(this, DashboardActivity::class.java)
            startActivity(intent)
            finish()

            val usernameEditText = findViewById<EditText>(R.id.editTextUsername)
            val passwordEditText = findViewById<EditText>(R.id.editTextPassword)
            val loginButton = findViewById<Button>(R.id.buttonLogin)
            val signUpButton = findViewById<Button>(R.id.buttonGoToSignUp)

            loginButton.setOnClickListener {
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (username == "user" && password == "pass") {
                    val intent = Intent(this, DashboardActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                }
            }

            signUpButton.setOnClickListener {
                val intent = Intent(this, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}