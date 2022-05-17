package com.example.marvel.data.network

import com.example.marvel.data.network.dto.ResponseDataDTO
import com.example.marvel.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

// Use DTO
interface MarvelService {
    @GET("/v1/public/characters?")
    suspend fun getAllCharacters(
        @Query("apikey")apikey:String = Constants.API_KEY,
        @Query("ts")ts:String = Constants.timeStamp,
        @Query("hash")hash:String = Constants.hash(),
        @Query("offset")offset:String
    ):ResponseDataDTO
}