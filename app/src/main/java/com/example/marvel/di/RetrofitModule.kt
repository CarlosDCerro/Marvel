package com.example.marvel.di

import com.example.marvel.data.database.dao.MovieCharacterDao
import com.example.marvel.data.network.MarvelRepositoryAdapter
import com.example.marvel.data.network.MarvelService
import com.example.marvel.domain.model.repository.MarvelRepository
import com.example.marvel.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    @Provides
    @Singleton
    fun providerMarvelApi(): MarvelService {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MarvelService::class.java)
    }

    @Provides
    @Singleton
    fun provideMarvelRepository(marvelService: MarvelService, characterDao: MovieCharacterDao): MarvelRepository {
        return MarvelRepositoryAdapter(marvelService, characterDao)
    }
}