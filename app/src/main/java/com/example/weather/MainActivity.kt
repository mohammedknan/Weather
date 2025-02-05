package com.example.weather

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val BASE_URL = "https://api.weatherapi.com/v1/"
    private val API_KEY = "c7cb884a7bec4222b87225029250302"
    private lateinit var listView: ListView
    private val cities = listOf(  "Amman", "Zarqa", "Irbid", "Aqaba", "Ajloun")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, cities)

        listView.adapter = adapter

        listView.setOnItemClickListener { _, _, position, _ ->
            val selectedCity = cities[position]
            getWeatherData(selectedCity)

        }

    }


    private fun getWeatherData(city: String) {
         val TAG = "RESPONSE"


        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(WApiServer::class.java)

        api.getWeather(API_KEY, city).enqueue(object : Callback<WeatherResponse> {

            override fun onResponse(call: Call<WeatherResponse>, response: Response<WeatherResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val weather = response.body()!!

                    val result = " City :  ${weather.location.name}  (${weather.location.country}) \n \n Temperature_C: " +
                            " ${weather.current.temp_c} \n \n Temperature_F: ${weather.current.temp_f}"

                    val intent = Intent(this@MainActivity, main1::class.java)
                    intent.putExtra("WEATHER_DATA", result)
                    startActivity(intent)
                } else {
                    Log.e(TAG, "Response not successful")
                    Toast.makeText(this@MainActivity, "Failed to load weather data", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {
                Log.e(TAG, "Error: ${t.message}")
                Toast.makeText(this@MainActivity, "Error: Unable to fetch weather data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}































//    override fun onItemClick(a: AdapterView<*>?, view: View?, pos: Int, id: Long) {
//
//        val data = a?.getItemAtPosition(pos).toString()
//        val intent = Intent(this, main1::class.java)
//        intent.putExtra("key", data)
//        startActivity(intent)
//
//    }
//


















//    private fun getAllComments(){
//
//val api = Retrofit.Builder()
//    .baseUrl(BASE_URL)
//    .addConverterFactory(GsonConverterFactory.create())
//    .build()
//    .create(WApiServer::class.java)
//
//    api.getComments().enqueue(object : Callback<List<Comments>>{
//
//        override fun onResponse(call: Call<List<Comments>>, response: Response<List<Comments>>)
//
//        {
//            val mmodel : List<Comments> = response.body()!!
//            val stringBuilder = StringBuilder()
//            for ( i in mmodel)
//            {
//                stringBuilder.append(i.name )
//                stringBuilder.append(i.temp_c)
//                stringBuilder.append(i.temp_f)
//
//            }
//            var a = findViewById(R.id.textView1) as TextView
//
//            a.movementMethod = ScrollingMovementMethod()
//            a.text = stringBuilder
//
//        }
//
//        override fun onFailure(call: Call<List<Comments>>, t: Throwable) {
 //           Log.i(TAG ,"onResponse : ${t.message}")
//
//        }
//
//    })
//
//}






//
//    private fun fetchCurrent(): Thread {
//        return Thread{
//
//            var name ="Amman"
//            val url=URL("https://api.weatherapi.com/v1/current.json?key=c7cb884a7bec4222b87225029250302&q=${name}")
//            val conection = url.openConnection() as HttpURLConnection
//            if(conection.responseCode ==200)
//            {
//                val inputSystem =conection.inputStream
//                println(inputSystem.toString())
//            }
//            else{
//                val inputSystem =conection.inputStream
//                println(inputSystem.toString())
//
//               // binding.baseCurrency.text = "Failed Connection"
//            } }
//
//
//    }





