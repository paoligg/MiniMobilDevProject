package com.example.miniprojectpaoligblan

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.miniprojectpaoligblan.adapter.DisneyCharacterAdapter
import com.example.miniprojectpaoligblan.api.DisneyApiService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class DisneyCharacterActivity : AppCompatActivity() {
    private val BASE_URL = "https://api.disneyapi.dev/"

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: DisneyCharacterAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disney_characters)
        getAllCharacters()

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }

    private fun showError(message: String) {
        println("Error: $message")
    }
    private fun getAllCharacters() {
        val api = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(DisneyApiService::class.java)

        api.getCharacters().enqueue(object : Callback<DisneyApiResponse> {
            override fun onResponse(
                call: Call<DisneyApiResponse>,
                response: Response<DisneyApiResponse>
            ) {
                if (response.isSuccessful) {
                    val characters = response.body()?.data
                    adapter = DisneyCharacterAdapter(characters!!)
                    recyclerView.adapter = adapter
                    for(character in characters!!) {
                        Log.i("DisneyCharacterActivity", "Name: ${character.name}")
                    }
                }
            }

            override fun onFailure(call: Call<DisneyApiResponse>, t: Throwable) {
                Log.i("DisneyCharacterActivity", "Error: ${t.message}")
            }

        })

    }
}
