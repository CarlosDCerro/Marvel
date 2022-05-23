package com.example.marvel.ui.screens.main

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.marvel.ui.screens.navigation.AppScreens

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.MarvelApp.route){
        composable(route = AppScreens.MarvelApp.route){
            MarvelApp(
                viewModel = hiltViewModel(),
                navControllerMarvelApp = navController
            )
        }
        composable(route = AppScreens.DetailMain.route){
            //MainDetail()
        }
    }
}