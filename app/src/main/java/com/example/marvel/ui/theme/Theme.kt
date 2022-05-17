package com.example.marvel.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = white,
    primaryVariant = C4,
    secondary = C2,
    secondaryVariant = C5,
    background = C4
)

private val LightColorPalette = lightColors(
    primary = black,
    primaryVariant = C10,
    secondary = C8,
    secondaryVariant = C7,
    onBackground = C3,
    onPrimary = C9,
    background = C1
)

@Composable
fun MarvelTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }
    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}