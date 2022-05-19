package com.example.marvel.domain.model

import com.example.marvel.data.database.entity.MovieCharacterEntity
import com.example.marvel.data.network.dto.Comic
import com.example.marvel.data.network.dto.MovieCharacterDTO
import com.example.marvel.util.common.Thumbnail

data class MovieCharacter(
    val id: Int,
    val name: String,
    val description: String,
    val thumbnail: Thumbnail,
    val comics: Comic?
)
fun MovieCharacterDTO.toDomain() = MovieCharacter(
        id,
        name,
        description,
        thumbnail,
        comics)

fun MovieCharacterEntity.toDomain() = MovieCharacter(
        id,
        name,
        description,
        thumbnail,
        null)

