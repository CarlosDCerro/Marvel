package com.example.marvel.ui.screens.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun Desc(descriptions: String){
    Text(descriptions,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Start)
}