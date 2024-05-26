package com.example.simulacro_tp3_ort.ui.views.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PetApiBuilder {
    private val BASE_URL = "https://dog.ceo/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun create(): PetsApiService {
        return retrofit.create(PetsApiService::class.java)
    }

}