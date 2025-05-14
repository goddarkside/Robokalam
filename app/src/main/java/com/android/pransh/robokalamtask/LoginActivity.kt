package com.android.pransh.robokalamtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginActivity : AppCompatActivity() {
    private lateinit var emailEt: EditText
    private lateinit var loginBtn: Button
    private lateinit var registerRedirectBtn: TextView
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        session = SessionManager(this)

        emailEt = findViewById(R.id.etEmail)
        loginBtn = findViewById(R.id.btnLogin)
        registerRedirectBtn = findViewById(R.id.tvRegisterRedirect)

        loginBtn.setOnClickListener {
            val emailInput = emailEt.text.toString().trim()
            val storedEmail = session.getUserName() // could use separate getter

            if (emailInput == session.prefs.getString("email", "")) {
                session.saveUser(session.getUserName(), emailInput)
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Invalid email. Try again or register.", Toast.LENGTH_SHORT).show()
            }
        }

        registerRedirectBtn.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}