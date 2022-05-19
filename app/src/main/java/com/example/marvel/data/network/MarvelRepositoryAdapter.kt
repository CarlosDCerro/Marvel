package com.example.marvel.data.network

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.marvel.data.database.dao.MovieCharacterDao
import com.example.marvel.data.database.entity.toEntity
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.domain.model.toDomain
import java.util.stream.Collectors.toList
import javax.inject.Inject

// Map DTO to Domain
class MarvelRepositoryAdapter @Inject constructor(
    private val marvelService: MarvelService,
    private val movieCharacterDao: MovieCharacterDao
) : MarvelRepository {
    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun getAllCharacterFromApi(offset: Int): List<MovieCharacter> {
        val response = marvelService.getAllCharacters(offset = offset.toString())
        val characters = response.data.movieCharacterDTOS
        return characters.stream()
            .map { it.toDomain() }
            .collect(toList())
    }

    override suspend fun getAllCharacterFromRoom(): List<MovieCharacter> {
        TODO("Not yet implemented")
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override suspend fun insertCharacter(characters: List<MovieCharacter>) {
        movieCharacterDao.insertAll(
            characters.stream()
                .map{it.toEntity()}
                .collect(toList()))
    }

    override suspend fun clearCharacter() {
        movieCharacterDao.clearCharacters()
    }

    override suspend fun findByCharacterName(name: String): MovieCharacter {
        TODO("Not yet implemented")
    }

}