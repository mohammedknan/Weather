//package com.example.weather
//
//data class WeatherResponse(
//    val name:String,
//    val temp_f:String,
//    val temp_c:String,
//
//    )

package com.example.weather

data class WeatherResponse(
    val location: Location,
    val current: Current
)

data class Location(
    val name: String,
    val country: String
)

data class Current(
    val temp_c: Double,
    val temp_f: Double,
)