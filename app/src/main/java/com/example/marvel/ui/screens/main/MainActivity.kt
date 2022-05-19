package com.example.marvel.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.marvel.ui.CharactersList.CharactersViewModel
import com.example.marvel.ui.theme.MarvelTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
           MarvelApp { GeneralView() }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GeneralView(){
    CallApi()
    Scaffold(topBar = {
        MainAppBar()
    }) {
        //ListCharacter(personajes = )
    }
}

@Composable
fun CallApi(viewModel: CharactersViewModel = hiltViewModel()){
    val offset = 20
    val movieCharacters = viewModel.getAllCharactersData(offset)

}


@Composable
fun MarvelApp(content: @Composable ()  -> Unit){
    MarvelTheme{
        Surface(color = MaterialTheme.colors.background) {
            content()
        }
    }
}










