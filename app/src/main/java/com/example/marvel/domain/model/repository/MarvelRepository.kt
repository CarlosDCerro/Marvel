package com.example.marvel.domain.model.repository

import com.example.marvel.domain.model.MovieCharacter

interface MarvelRepository {
    suspend fun getAllCharacterFromApi(offset: Int): List<MovieCharacter>
    suspend fun getAllCharacterFromRoom(offset: Int): List<MovieCharacter>
    suspend fun insertCharacter(characters: List<MovieCharacter>)
    suspend fun clearCharacter()
    suspend fun findByCharacterName(name: String): MovieCharacter
}