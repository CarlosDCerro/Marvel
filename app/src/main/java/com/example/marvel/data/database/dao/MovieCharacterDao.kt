package com.example.marvel.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.marvel.data.database.entity.MovieCharacterEntity

@Dao
interface MovieCharacterDao {
    @Query("SELECT * FROM character ORDER BY id ASC")
    suspend fun getAll(): LiveData<List<MovieCharacterEntity>>

    @Query("SELECT * FROM character WHERE name LIKE '%' || :name || '%' ORDER BY id ASC")
    suspend fun getByName(name: String): MovieCharacterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: List<MovieCharacterEntity>)

    @Query("DELETE FROM character")
    fun clearCharacters()
}