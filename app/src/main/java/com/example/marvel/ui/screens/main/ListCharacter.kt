package com.example.marvel.ui.screens.main

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.marvel.domain.model.MovieCharacter

@Composable
fun ListCharacter(personajes: List<MovieCharacter>){
    LazyColumn{
        items(personajes){ personaje ->
            ItemCharracter(personaje)
        }
    }
}