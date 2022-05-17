package com.example.marvel.ui.CharactersList

import com.example.marvel.domain.model.MovieCharacter

data class MarvelListState(
    val isLoading: Boolean = false,
    val characterList: List<MovieCharacter> = emptyList(),
    val error: String = ""
)
