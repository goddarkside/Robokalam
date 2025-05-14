package com.android.pransh.robokalamtask

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PortfolioActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etCollege: EditText
    private lateinit var etSkills: EditText
    private lateinit var etProjectTitle: EditText
    private lateinit var etProjectDescription: EditText
    private lateinit var btnSave: Button
    private lateinit var tvResult: TextView

    private lateinit var db: AppDatabase
    private lateinit var dao: PortfolioDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_portfolio)

        etName = findViewById(R.id.etName)
        etCollege = findViewById(R.id.etCollege)
        etSkills = findViewById(R.id.etSkills)
        etProjectTitle = findViewById(R.id.etProjectTitle)
        etProjectDescription = findViewById(R.id.etProjectDescription)
        btnSave = findViewById(R.id.btnSave)
        tvResult = findViewById(R.id.tvResult)

        db = AppDatabase.getDatabase(this)
        dao = db.portfolioDao()

        btnSave.setOnClickListener {
            val name = etName.text.toString().trim()
            val college = etCollege.text.toString().trim()
            val skills = etSkills.text.toString().trim()
            val projectTitle = etProjectTitle.text.toString().trim()
            val projectDesc = etProjectDescription.text.toString().trim()

            if (name.isEmpty() || college.isEmpty() || skills.isEmpty()
                || projectTitle.isEmpty() || projectDesc.isEmpty()) {
                Toast.makeText(this, "All fields required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val portfolio = Portfolio(
                name = name,
                college = college,
                skills = skills,
                projectTitle = projectTitle,
                projectDescription = projectDesc
            )

            lifecycleScope.launch {
                dao.insertPortfolio(portfolio)
                val saved = dao.getPortfolio()
                withContext(Dispatchers.Main) {
                    tvResult.text = "Saved Portfolio:\nName: ${saved?.name}\nCollege: ${saved?.college}\nSkills: ${saved?.skills}\nProject: ${saved?.projectTitle}\nDescription: ${saved?.projectDescription}"
                }
            }
        }

    }
}