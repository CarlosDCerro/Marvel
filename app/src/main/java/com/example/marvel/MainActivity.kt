package com.example.marvel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.ui.CharactersList.CharactersViewModel
import com.example.marvel.ui.theme.C10
import com.example.marvel.ui.theme.MarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           MarvelTheme {
               GeneralView()
           } 
        }
    }
}

private val offset = 20

@Preview(showSystemUi = true)
@Composable
fun GeneralView(viewModel: CharactersViewModel = hiltViewModel()){
    Column(
        Modifier
            .fillMaxSize()){
        viewModel.getAllCharactersData(offset);
        Titulo()
        //ListCharacter(Prueba)
    }
}


@Composable
fun CallApi(){

}

@Composable
fun ListCharacter(personajes: List<MovieCharacter>){
    LazyColumn{
        items(personajes){ personaje ->
            ItemCharracter(personaje)
        }
    }
}


@Composable
fun Titulo(){
    MarvelTheme {
        Text(
            "Marvel",
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Start,
            modifier = Modifier
                .padding(12.dp)
        )
    }

}

@Composable
fun ItemCharracter(personaje: MovieCharacter){
    var expanded by remember { mutableStateOf(false)}
    Box(contentAlignment = Alignment.CenterStart,
        modifier = Modifier
            .padding(horizontal = 20.dp, vertical = 8.dp)
            .clickable {
                expanded = !expanded
            }
        ) {
        Name(personaje.name,
            personaje.description,
            if(expanded) Int.MAX_VALUE else 1)
        Photo(personaje.thumbnail.path, personaje.thumbnail.path)
    }
}

@Composable
fun Name(name: String, poderes: String, lines: Int = Int.MAX_VALUE){
    Card(elevation = 16.dp,
    shape = RoundedCornerShape(16.dp),
    backgroundColor = C10,
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
                    textAlign = TextAlign.Start)
                Text(poderes,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Start,
                    maxLines = lines)
            }
        }
    }
}

@Composable
fun Photo(imgUrl: String, imgExt: String){
    Card(elevation = 16.dp,
        shape = RoundedCornerShape(16.dp),
        modifier = Modifier
            .height(220.dp)
            .width(150.dp)) {
        val image ="${imgUrl}/portrait_xlarge.${imgExt}"
        AsyncImage(
            model = image,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            alignment = Alignment.Center
        )
    }
}

