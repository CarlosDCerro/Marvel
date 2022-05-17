package com.example.marvel.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.marvel.data.database.dao.MovieCharacterDao
import com.example.marvel.data.database.entity.MovieCharacterEntity

@Database(entities = [MovieCharacterEntity::class], version = 1)
abstract class DataBase: RoomDatabase() {
    abstract fun characterDao(): MovieCharacterDao
}