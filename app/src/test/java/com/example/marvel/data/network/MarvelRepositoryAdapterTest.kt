package com.example.marvel.data.network

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvel.data.database.dao.MovieCharacterDao
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
    fun `get all characters from api and mapping the response`(): Unit = runBlocking {
        //Given
        val listCharactersApi = TestMarvelRepositpryAdapterData.getDataFromApi()
        val listCharactersRoom = TestMarvelRepositpryAdapterData.getDataFromRoom()

        coEvery { marvelService
            .getAllCharacters(offset = any())
            .data
            .movieCharacterDTOS } returns listCharactersApi

        coEvery { movieCharacterDao.getAll() } returns listCharactersRoom

        //when
        val response = marvelRepositoryAdapter.getAllCharacterFromApi(1)

        //Then
        //assertTrue(response == listCharacters[0])
    }
}