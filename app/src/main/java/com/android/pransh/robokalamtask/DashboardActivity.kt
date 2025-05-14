package com.android.pransh.robokalamtask

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DashboardActivity : AppCompatActivity() {
    private lateinit var session: SessionManager
    private lateinit var tvWelcome: TextView
    private lateinit var btnPortfolio: Button
    private lateinit var btnQuote: Button
    private lateinit var btnAbout: Button
    private lateinit var btnLogout: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dashboard)

        session = SessionManager(this)

        tvWelcome = findViewById(R.id.tvWelcome)
        btnPortfolio = findViewById(R.id.btnPortfolio)
        btnQuote = findViewById(R.id.btnQuote)
        btnAbout = findViewById(R.id.btnAbout)
        btnLogout = findViewById(R.id.btnLogout)

        // Set welcome message
        tvWelcome.text = "Welcome, ${session.getUserName()}!"

        btnPortfolio.setOnClickListener {
            startActivity(Intent(this, PortfolioActivity::class.java))
        }

        btnQuote.setOnClickListener {
            startActivity(Intent(this, QuoteActivity::class.java))
        }

        btnAbout.setOnClickListener {
            startActivity(Intent(this, AboutActivity::class.java))
        }

        btnLogout.setOnClickListener {
            session.logout()
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        }
    }
}