package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvel.domain.model.MovieCharacter

@Composable
fun ItemCharracter(personaje: MovieCharacter){

    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
    ) {
        Name(
            name = personaje.name,
            descriptions = personaje.description)
        Photo(imgUrl = personaje.thumbnail.path,
            imgExt = personaje.thumbnail.path)
    }
}