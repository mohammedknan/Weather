package com.example.weather

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class main1 : AppCompatActivity() {





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main1)

     //   val selectedItem = intent.getStringExtra("selectedItem")

        val textViewWeather = findViewById(R.id.textView) as TextView

        val weatherData = intent.getStringExtra("WEATHER_DATA")

        textViewWeather.text = weatherData

    }
}