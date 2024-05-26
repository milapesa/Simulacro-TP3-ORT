package com.example.simulacro_tp3_ort.ui.views.services

import com.example.simulacro_tp3_ort.ui.views.entities.DogsImageResponse
import retrofit2.Call
import retrofit2.http.GET

interface PetsApiService {
    @GET("api/breeds/image/random/20")
    fun getDogs(): Call<DogsImageResponse>
}