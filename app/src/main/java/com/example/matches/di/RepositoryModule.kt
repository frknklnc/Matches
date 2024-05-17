package com.example.matches.di

import com.example.matches.data.repository.MatchesRepositoryImpl
import com.example.matches.domain.repository.MatchesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindMatchesRepository(repositoryImpl: MatchesRepositoryImpl): MatchesRepository
}