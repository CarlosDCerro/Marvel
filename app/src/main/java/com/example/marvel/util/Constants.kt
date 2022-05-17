package com.example.marvel.util

import android.util.Log
import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object{
        const val BASE_URL = "https://gateway.marvel.com"
        const val API_KEY = "d43a7b039d59411f2e0b9d2ed15d2d8a"
        const val PRIVATE_KEY = "3347c773c16e8d2e786eccc5f4a3439466410b89"
        const val LIMIT = "20"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        fun hash():String{
            val input = "$timeStamp$PRIVATE_KEY$API_KEY"
            val md = MessageDigest.getInstance("MD5")
            val hs = BigInteger(1,md
                .digest(input.toByteArray()))
                .toString(16)
                .padStart(32,'0')
            Log.d("HASH: ", hs)
            return hs
        }
    }
}