package com.example.marvel.domain.useCase

import com.example.marvel.data.network.MarvelRepositoryAdapter
import com.example.marvel.domain.model.MovieCharacter
import javax.inject.Inject

class GetAllCharactersRoomUseCase @Inject constructor(
    private val repository: MarvelRepositoryAdapter
) {
    operator fun invoke(offset: Int):List<MovieCharacter>{
        val movieCharacter = repository.getAllCharacterFromRoom(offset = offset)
    }
}