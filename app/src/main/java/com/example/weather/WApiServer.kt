package com.example.weather


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WApiServer {
    @GET("current.json")
    fun getWeather(
        @Query("key") apiKey: String,
        @Query("q") city: String
    ): Call<WeatherResponse>
}

