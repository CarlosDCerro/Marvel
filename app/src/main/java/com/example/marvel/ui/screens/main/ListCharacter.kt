package com.example.marvel.ui.screens.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.marvel.data.database.entity.MovieCharacterEntity

@Composable
fun ListCharacter(personajes: List<MovieCharacterEntity>){
    LazyColumn{
        items(personajes){ personaje ->
            ItemCharracter(personaje)
        }
    }
}