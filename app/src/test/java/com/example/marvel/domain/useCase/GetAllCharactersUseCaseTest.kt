package com.example.marvel.domain.useCase

import com.example.marvel.TestMovieCharacterData
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.util.Response
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

class GetAllCharactersUseCaseTest {

    @MockK
    private lateinit var repository: MarvelRepository

    @InjectMockKs
    //private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase
    private lateinit var expected: List<Response<List<MovieCharacter>>>

    @Before
    fun setup() {
        MockKAnnotations.init(this)
        expected = listOf(Response.Loading(), Response.Success(TestMovieCharacterData.getMovieCharacterData()))
    }

    @Test
    fun `invoke Not Empty Response From Api`() = runBlocking {
        // Mock
        val marvelRepository = mock<MarvelRepository>() {
            onBlocking {
                getAllCharacterFromApi(any())
            } doReturn TestMovieCharacterData.getMovieCharacterData()
        }
        //Inject Mock
        val getAllCharactersUseCase = GetAllCharactersUseCase(marvelRepository)

        // Test and verify
        val flow = getAllCharactersUseCase(1).toList()
        assertTrue(flow[1].data == expected[1].data)
    }

    @Test
    fun `invoke Empty Response From Api And Then Return Data From Room`() = runBlocking {
        // Mock
        val marvelRepository = mock<MarvelRepository>() {
            onBlocking {
                getAllCharacterFromRoom(any())
            } doReturn TestMovieCharacterData.getMovieCharacterData()

            onBlocking {
                getAllCharacterFromApi(any())
            } doReturn emptyList()
        }
        val getAllCharactersUseCase = GetAllCharactersUseCase(marvelRepository)

        // Test and verify
        val flow = getAllCharactersUseCase(1).toList()
        assertTrue(flow[1].data == expected[1].data)
    }

}