package com.example.marvel.ui.screens.navigation

sealed class AppScreens(val route: String){
    object MarvelApp: AppScreens(route = "marvel_app_scren")
    object DetailMain: AppScreens(route = "detail_scren")
}
