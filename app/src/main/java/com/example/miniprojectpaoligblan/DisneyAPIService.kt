package com.example.miniprojectpaoligblan.api

import com.example.miniprojectpaoligblan.DisneyApiResponse
import retrofit2.http.GET
import retrofit2.Call

interface DisneyApiService {
    @GET("character")
    fun getCharacters(): Call<DisneyApiResponse>
}
