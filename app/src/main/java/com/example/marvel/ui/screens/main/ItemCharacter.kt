package com.example.marvel.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.ui.theme.C3


@Composable
fun ItemCharracter(
    personage: MovieCharacter,
    navControllerItem: NavController
    ){

    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .background(C3)
    ) {
        Name(
            name = personage.name,
            descriptions = personage.description)
        Photo(imgUrl = personage.thumbnail.path,
            imgExt = personage.thumbnail.extension)
    }
}