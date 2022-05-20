package com.example.marvel.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


/*private val im = "http://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"
private val xt = "jpe"
private val na = "Iron Man"
private val nDes = "Ianron MUsa la función Spacer El triatlón Ironman es una serie de carreras organizadas por World Triathlon Corporation. Los participantes tienen que cubrir 3 pruebas extremas: 3,86 km de natación en mar abierto, 180 km de ciclismo y 42,2 km de carrera a pie. La carrera tiene un tiempo límite de 17 horas.  para representar un layout cuyo espacio estará vacío. Debido a su simplicidad, su definición sólo toma como argumento al modificador para establecer sus propiedades:Spider-Man, traducido en ocasiones como El Hombre Araña, \u200B\u200B es un personaje creado por los estadounidenses Stan Lee y Steve Ditko, \u200B\u200B e introducido en el cómic Amazing Fantasy n.° 15, publicado por Marvel Comics en agosto de 1962."
*/

@Composable
fun MainDetail(name: String,
           Desc:String,
           url: String,
           ext: String) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(4.dp)
            .background(MaterialTheme.colors.background)
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