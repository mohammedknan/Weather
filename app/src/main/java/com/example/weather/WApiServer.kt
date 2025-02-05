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



//import retrofit2.Call
//import retrofit2.http.GET
//
//
//interface WApiServer {
//@GET("comments")
//fun getComments(
////    @Query("q") location:String,
////    @Query("appied") token:String
//
//):Call<List<WeatherResponse>>
//
//}



//import retrofit2.Call
//import retrofit2.http.GET
//import retrofit2.http.Query
//
//
//
//interface WApiServer {
//    @GET("current.json?key=c7cb884a7bec4222b87225029250302")
//    fun getWeather(@Query("q") city: String): Call<WeatherResponse>
//}




