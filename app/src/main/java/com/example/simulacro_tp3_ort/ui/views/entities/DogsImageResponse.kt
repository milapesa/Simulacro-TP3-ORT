package com.example.simulacro_tp3_ort.ui.views.entities

import com.google.gson.annotations.SerializedName

data class DogsImageResponse(
    @SerializedName("message") val images: List<String>
)
