package com.example.marvel.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.ui.CharactersList.CharactersViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            MarvelApp()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    GeneralView(personage = listOf())
}


@Composable
fun GeneralView(
    onAddClick: (() -> Unit)? = null,
    personage: List<MovieCharacter>
){
    onAddClick?.invoke()
    Scaffold(topBar = {
        MainAppBar()
    }) {
        onAddClick?.invoke()
        ListCharacter(personajes = personage)
    }
}

@Composable
fun MarvelApp(viewModel: CharactersViewModel = hiltViewModel()){
    val offset = 80
    val state = viewModel._marvelValue.collectAsState().value
    GeneralView(
        onAddClick = {
            viewModel.getAllCharactersData(offset)
        },
        personage = state.characterList
    )
}