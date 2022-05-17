package com.example.marvel.data.network.dto

import com.google.gson.annotations.SerializedName

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    @SerializedName("results") val movieCharacterDTOS: List<MovieCharacterDTO>,
    val total: Int
)
