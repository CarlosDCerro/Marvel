package com.example.marvel

import android.app.Application
import androidx.room.Room
import com.example.marvel.data.database.DataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MarvelApplication:Application(){
    val room = Room.databaseBuilder(
        this,
        DataBase::class.java,
        "CharacteresDB"
    ).build()
}