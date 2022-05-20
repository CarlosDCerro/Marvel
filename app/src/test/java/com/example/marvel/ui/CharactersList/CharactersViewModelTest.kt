package com.example.marvel.ui.CharactersList

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.marvel.TestMovieCharacterData
import com.example.marvel.domain.model.MovieCharacter
import com.example.marvel.domain.useCase.GetAllCharactersUseCase
import com.example.marvel.util.Response
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.kotlin.any
import org.mockito.kotlin.doReturn
import org.mockito.kotlin.mock

@ExperimentalCoroutinesApi
class CharactersViewModelTest {

    @MockK
    private lateinit var getAllCharacterUseCase: GetAllCharactersUseCase

    @InjectMockKs
    private lateinit var charactersViewModel: CharactersViewModel

    private lateinit var expect: List<Response<List<MovieCharacter>>>

    @get:Rule
    var rule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup(){
        MockKAnnotations.init(this)
        expect = listOf(
            Response.Loading(),
            Response.Success(TestMovieCharacterData.getMovieCharacterData())
        )

        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @After
    fun onAfter() {
        Dispatchers.resetMain()
    }


    @Test
    fun `invoke No Empty Response From ViewModel`() = runTest {
        //Given
        coEvery { getAllCharacterUseCase(any()) } returns flowOf(expect[1])

        //when
        val response =  launch { getAllCharacterUseCase(1).toList() }
        charactersViewModel.getAllCharactersData(1)

        //Then
        //assert(charactersViewModel._marvelValue.value is response)
    }

    @Test
    fun `invoke Not Empty Response From getAllCharacterUseCase`() = runBlocking {
        // Mock
        val getAllCharactersUseCaseMock = mock<GetAllCharactersUseCase>() {
            onBlocking {
                invoke(any())
            } doReturn flowOf(expect[0])
        }
        //Inject Mock
        val charactersViewModel = CharactersViewModel(getAllCharactersUseCaseMock)

        // Test and verify
        launch { charactersViewModel.getAllCharactersData(1) }
        verify { getAllCharactersUseCaseMock(1) }
    }

}