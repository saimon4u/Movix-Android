package com.example.movix.di

import com.example.movix.details.data.repository.RepositoryImpl
import com.example.movix.details.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DetailsRepositoryModule {

    @Binds
    @Singleton
    abstract fun bindDetailsRepository(
        detailsRepositoryImpl: RepositoryImpl
    ): Repository
}