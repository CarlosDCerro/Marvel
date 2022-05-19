package com.example.marvel.ui.screens.main

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.Search
import androidx.compose.runtime.Composable


@Composable
fun MainAppBar() {
    TopAppBar(
        title = { Text(text = "Personajes") },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.TwoTone.Search,
                    contentDescription = "Buscar personajes")
            }
        }
    )
}