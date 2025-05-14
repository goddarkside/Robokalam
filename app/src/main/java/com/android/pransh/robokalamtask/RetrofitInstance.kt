package com.android.pransh.robokalamtask

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api: QuoteApiService by lazy {
        Retrofit.Builder()
            .baseUrl("https://zenquotes.io/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuoteApiService::class.java)
    }
}