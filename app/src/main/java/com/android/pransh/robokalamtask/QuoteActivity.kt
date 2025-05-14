package com.android.pransh.robokalamtask

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class QuoteActivity : AppCompatActivity() {
    private lateinit var tvQuote: TextView
    private lateinit var tvAuthor: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_quote)

        tvQuote = findViewById(R.id.tvQuote)
        tvAuthor = findViewById(R.id.tvAuthor)

        fetchQuote()

    }

    private fun fetchQuote() {
        val call = RetrofitInstance.api.getRandomQuote()
        call.enqueue(object : Callback<List<QuoteResponse>> {
            override fun onResponse(
                call: Call<List<QuoteResponse>>,
                response: Response<List<QuoteResponse>>
            ) {
                if (response.isSuccessful && response.body() != null) {
                    val quote = response.body()!![0]
                    tvQuote.text = "\"${quote.q}\""
                    tvAuthor.text = "- ${quote.a}"
                } else {
                    tvQuote.text = "Failed to load quote."
                }
            }

            override fun onFailure(call: Call<List<QuoteResponse>>, t: Throwable) {
                tvQuote.text = "Error: ${t.message}"
            }
        })
    }
}