package com.example.marvel.ui.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.marvel.ui.theme.C8

@Preview(showBackground = true)
@Composable
fun SearchView(){
    val search by remember { mutableStateOf("") }
    Surface(
        modifier = Modifier
        .fillMaxWidth(),
        color = Color.Transparent,
        elevation = 8.dp){

        Row(modifier = Modifier.fillMaxWidth()) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                value = search,
                onValueChange = {
                    TODO() // Hacer la búsqueda en Room por el nombre
                },
                label = {
                    Text(text = "Search your favorite character...",
                    color = C8
                    )
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                ),
                leadingIcon = {
                    Icon(
                        Icons.Rounded.Search,
                        contentDescription = "Search your favorite character of Marvel universe.",
                    tint = C8)
                }

            )

        }
    }
}