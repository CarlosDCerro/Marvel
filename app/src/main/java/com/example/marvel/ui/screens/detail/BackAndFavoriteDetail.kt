package com.example.marvel.ui.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun BackAndFavoriteDetail() {
    var expanded by remember { mutableStateOf(false) }
    Row(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 8.dp, start = 8.dp),
    ) {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                Icons.Rounded.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(Modifier.fillMaxWidth(0.83f))
        IconButton(onClick = { expanded = !expanded }) {
            val colorFavorite = if (expanded) Color.Red else Color.LightGray
            val scaleFavorite = if (expanded) 1.5f else 1f
            Icon(
                Icons.Rounded.Favorite,
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp)
                    .scale(scaleFavorite),
                tint = colorFavorite
            )
        }

    }
}