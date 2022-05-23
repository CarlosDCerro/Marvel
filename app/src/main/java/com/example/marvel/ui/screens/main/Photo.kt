package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent


@Composable
fun Photo(imgUrl: String, imgExt: String){
    Card(elevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(220.dp)
            .width(150.dp))
    {
        val imageUrl = imgUrl.replace(
            oldValue = "http",
            newValue = "https",
            ignoreCase = false
        )
        val image ="${imageUrl}/portrait_xlarge.${imgExt}"
        //val image ="${imgUrl}/portrait_xlarge.${imgExt}"
        SubcomposeAsyncImage(
            model = image,
            contentDescription = "stringResource()",
            contentScale = ContentScale.Crop
        ) {
            val state = painter.state
            if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .scale(0.7f)
                        .align(Alignment.Center)
                )
            } else {
                SubcomposeAsyncImageContent()
            }
        }
    }
}

