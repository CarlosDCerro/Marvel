package com.example.marvel.ui.CharactersList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvel.domain.useCase.GetAllCharactersUseCase
import com.example.marvel.util.Response
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

// use domain model
@HiltViewModel
class CharactersViewModel @Inject constructor(
    private val getAllCharactersUseCase: GetAllCharactersUseCase
): ViewModel() {
    private val marvelValue = MutableStateFlow(MarvelListState())
    var _marvelValue: StateFlow<MarvelListState> = marvelValue

    fun getAllCharactersData(offset: Int) = viewModelScope.launch(Dispatchers.IO) {
        getAllCharactersUseCase(offset = offset).collect(){
            when(it){
                is Response.Success -> {
                    marvelValue.value = MarvelListState(
                        characterList = it.data?: emptyList())
                }
                is Response.Loading -> {
                    marvelValue.value = MarvelListState(
                        isLoading = true)
                }
                is Response.Error -> {
                    marvelValue.value = MarvelListState(
                        error = it.message?: "Ha ocurrido un error inesperado.")
                }
            }
        }
    }
}