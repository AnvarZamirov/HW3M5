package com.example.hw3m5

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitService {

    val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://love-calculator.p.rapidapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create<ApiService>()
}