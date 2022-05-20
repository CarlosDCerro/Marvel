package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.marvel.ui.theme.C8

@Preview(showBackground = true)
@Composable
fun MainAppBar() {
    Column {
        Text("Characters",
            fontSize = 36.sp,
            fontWeight = FontWeight.ExtraBold,
            textAlign = TextAlign.Start,
            color = C8,
            modifier = Modifier.padding(start = 20.dp, bottom = 4.dp))

        SearchView()
    }
}