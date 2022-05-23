package com.example.marvel.ui.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.ui.theme.C3

@Composable
fun ListCharacter(
    personajes: List<MovieCharacter>,
    navControllerList: NavController
){
    LazyColumn(modifier = Modifier.background(C3)){
        items(items = personajes){ personaje ->
            ItemCharracter(
                personage = personaje,
                navControllerItem = navControllerList
            )
        }
    }
}