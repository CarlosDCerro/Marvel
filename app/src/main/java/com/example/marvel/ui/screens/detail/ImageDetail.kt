package com.example.marvel.ui.screens.detail

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.base.R
import coil.compose.AsyncImage
import coil.request.ImageRequest

private val im = "http://x.annihil.us/u/prod/marvel/i/mg/3/40/4bb4680432f73"
private val xt = "jpe"
private val na = "Iron Man"
private val nDes = "Ianron MUsa la función Spacer para representar un layout cuyo espacio estará vacío. Debido a su simplicidad, su definición sólo toma como argumento al modificador para establecer sus propiedades:"

@Preview(showSystemUi = true)
@Composable
fun ImageDetail(name: String = na, Desc:String = nDes, url: String = im, ext: String = xt) {
    Column(Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.Start) {
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .wrapContentSize(Alignment.TopCenter),
            contentAlignment = Alignment.BottomStart
        ) {
            AsyncImage(model = ImageRequest.Builder(LocalContext.current)
                .data("${url}/portrait_incredible.${ext}")
                .crossfade(true)
                .build(),
                placeholder = painterResource(R.drawable.abc_vector_test),
                contentDescription = stringResource(R.string.status_bar_notification_info_overflow),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.75f)
                    .border(
                        width = 0.dp,
                        color = MaterialTheme.colors.background,
                        shape = RoundedCornerShape(16.dp)
                    )
            )
            Text(name,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(start = 20.dp, bottom = 10.dp))
        }
        Spacer(Modifier.size(70.dp))
        Card(backgroundColor = Color.Transparent,
            shape = RoundedCornerShape(16.dp)
        ) {
            Text("Descripción",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(12.dp))
            Spacer(Modifier.size(20.dp))
        }
        Text(Desc,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(12.dp))



    }

}