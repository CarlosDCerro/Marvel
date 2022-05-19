package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

@Composable
fun Photo(imgUrl: String, imgExt: String){
    Card(elevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(220.dp)
            .width(150.dp)) {
        val image ="${imgUrl}/portrait_xlarge.${imgExt}"
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    }
}