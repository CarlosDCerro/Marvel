package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel.ui.theme.C10
import com.example.marvel.ui.theme.C4


@Composable
fun Name(name: String, descriptions: String){
    Card(elevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        backgroundColor = C4,
        modifier = Modifier
            .width(380.dp)) {
        Box(
            Modifier
                .wrapContentSize(Alignment.CenterStart)
                .padding(start = 160.dp, top = 8.dp, end = 8.dp)){
            Column(Modifier.padding(vertical = 8.dp) ) {
                Text(name,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Start,
                color = C10)

                Desc(descriptions = descriptions)
            }
        }
    }
}