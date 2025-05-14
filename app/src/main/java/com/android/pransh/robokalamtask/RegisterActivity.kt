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

class RegisterActivity : AppCompatActivity() {

    private lateinit var nameEt: EditText
    private lateinit var emailEt: EditText
    private lateinit var registerBtn: Button
    private lateinit var loginRedirectBtn: TextView
    private lateinit var session: SessionManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_register)

        session = SessionManager(this)

        nameEt = findViewById(R.id.etName)
        emailEt = findViewById(R.id.etEmail)
        registerBtn = findViewById(R.id.btnRegister)
        loginRedirectBtn = findViewById(R.id.tvLoginRedirect)

        registerBtn.setOnClickListener {
            val name = nameEt.text.toString().trim()
            val email = emailEt.text.toString().trim()

            if (name.isEmpty() || email.isEmpty()) {
                Toast.makeText(this, "Please enter all fields", Toast.LENGTH_SHORT).show()
            } else {
                session.saveUser(name, email)
                startActivity(Intent(this, DashboardActivity::class.java))
                finish()
            }
        }

        loginRedirectBtn.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

}