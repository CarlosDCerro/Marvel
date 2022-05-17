package com.example.marvel.domain.useCase

import com.example.marvel.domain.model.repository.MarvelRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Before
import org.junit.Test

class GetAllCharactersUseCaseTest {

    @MockK
    private lateinit var repository: MarvelRepository

    @InjectMockKs
    private lateinit var getAllCharactersUseCase: GetAllCharactersUseCase

    @Before
    fun setup() = MockKAnnotations.init(this)

    @Test
    fun `invoke Empty Response From Api`() = runBlockingTest {
        // Given
        coEvery { repository.getAllCharacterFromApi(1) } returns emptyList()

        // When
        getAllCharactersUseCase(20)

        // Then
        coVerify { repository.getAllCharacterFromRoom(20) }
    }
}