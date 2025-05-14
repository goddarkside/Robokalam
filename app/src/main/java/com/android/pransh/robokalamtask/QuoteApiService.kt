package com.android.pransh.robokalamtask

import retrofit2.Call
import retrofit2.http.GET

interface QuoteApiService {
    @GET("api/random")
    fun getRandomQuote(): Call<List<QuoteResponse>>
}