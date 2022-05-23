package com.example.marvel.ui.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.example.marvel.ui.theme.C10

private val im = "http://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"
private val xt = "jpe"
private val na = "Iron Man"
private val nDes = "Ianron MUsa la función Spacer El triatlón Ironman es una serie de carreras organizadas por World Triathlon Corporation. Los participantes tienen que cubrir 3 pruebas extremas: 3,86 km de natación en mar abierto, 180 km de ciclismo y 42,2 km de carrera a pie. La carrera tiene un tiempo límite de 17 horas.  para representar un layout cuyo espacio estará vacío. Debido a su simplicidad, su definición sólo toma como argumento al modificador para establecer sus propiedades:"

@Preview
@Composable
fun ImageDetail(name: String = na,
                url: String = im,
                ext: String = xt) {
    Card(
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.75f)) {

        Box(modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    0.25f to Color.Transparent,
                    0.75f to MaterialTheme.colors.onBackground,
                    startY = 0.0f,
                    endY = 2100.0f
                )
            ),
            contentAlignment = Alignment.BottomStart
        ){
            SubcomposeAsyncImage(
                model = "${url}/portrait_incredible.${ext}",
                contentDescription = "stringResource()",
                modifier = Modifier
                    .align(Alignment.Center)
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

            Text(name,
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                color = C10,
                modifier = Modifier.padding(start = 20.dp, bottom = 10.dp))
        }
    }
}