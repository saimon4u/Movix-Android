package com.example.movix.di

import com.example.movix.movie_list.data.repository.RepositoryImpl
import com.example.movix.movie_list.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindMovieRepository(
        movieRepositoryImpl: RepositoryImpl
    ): Repository
}