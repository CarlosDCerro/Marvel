package com.example.marvel.ui.screens.main

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.marvel.ui.theme.C1

@Composable
fun Desc(descriptions: String){
    val Desc = if(descriptions == "") "No more information..." else descriptions
    Text(
        text = Desc,
        fontSize = 20.sp,
        fontWeight = FontWeight.Light,
        textAlign = TextAlign.Start,
        color = C1,
        maxLines = 4)
}