package com.example.marvel.data.database.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.marvel.data.database.entity.MovieCharacterEntity

@Dao
interface MovieCharacterDao {
    @Query("SELECT * FROM character ORDER BY id ASC")
    fun getAll(): LiveData<List<MovieCharacterEntity>>

    @Query("SELECT * FROM character WHERE name LIKE '%' || :name || '%' ORDER BY id ASC")
    fun getByName(name: String): MovieCharacterEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertFavorite(characters: List<MovieCharacterEntity>)

    @Delete
    fun deleteFavorite(character: MovieCharacterEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(characters: List<MovieCharacterEntity>)

    @Query("DELETE FROM character")
    fun clearCharacters()
}