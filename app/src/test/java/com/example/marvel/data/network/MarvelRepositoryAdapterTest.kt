package com.example.marvel.data.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvel.data.database.dao.MovieCharacterDao
import com.example.marvel.data.network.dto.*
import com.example.marvel.util.common.Thumbnail
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MarvelRepositoryAdapterTest{
    @MockK
    private lateinit var marvelService: MarvelService

    @MockK
    private lateinit var movieCharacterDao: MovieCharacterDao

    private lateinit var marvelRepositoryAdapter: MarvelRepositoryAdapter

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun onBefore(){
        MockKAnnotations.init(this)
        marvelRepositoryAdapter = MarvelRepositoryAdapter(marvelService, movieCharacterDao)
    }

    @Test
    fun `get all characters from api and mapping the response`() = runBlocking {
        //Given

        coEvery { marvelService.getAllCharacters(offset = any()).data.movieCharacterDTOS } returns emptyList() //MockK de la respuesta del Api
        coEvery { movieCharacterDao.getAll() } returns emptyList() //MockK de la respuesta
        //when
        marvelRepositoryAdapter.getAllCharacterFromApi(1)
        //Then
        
    }


}