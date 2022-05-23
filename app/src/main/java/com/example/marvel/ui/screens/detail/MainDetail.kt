package com.example.marvel.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.marvel.ui.theme.C3

@Composable
fun MainDetail(name: String,
           Desc:String,
           url: String,
           ext: String) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(C3)
    ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(4.dp)
                .scrollable(
                    rememberScrollState(),
                    Orientation.Vertical,
                    enabled = true),
            horizontalAlignment = Alignment.Start) {

            ImageDetail(
                name = name,
                url = url,
                ext = ext
            )
            DescriptionDetail(
                Desc = Desc)
        }
        BackAndFavoriteDetail()
    }

}