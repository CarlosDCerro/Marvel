package com.example.marvel.domain.useCase

import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.util.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

// Use domain model
class GetAllCharactersUseCase @Inject constructor(
    private val repository: MarvelRepository
) {
    operator fun invoke(offset: Int): Flow<Response<List<MovieCharacter>>> = flow{
        try {
            emit(Response.Loading())
            var list = repository.getAllCharacterFromApi(offset = offset)
            if (list.isNotEmpty()) {
                repository.clearCharacter()
                repository.insertCharacter(list)
            } else {
                list = repository.getAllCharacterFromRoom(offset = offset)
            }
            emit(Response.Success(list))
        }
        catch (e:HttpException){
            emit(Response.Error(e.printStackTrace().toString()))
        }
        catch (e:IOException){
            emit(Response.Error(e.printStackTrace().toString()))
        }
    }
}