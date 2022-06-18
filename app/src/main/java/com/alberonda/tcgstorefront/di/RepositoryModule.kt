package com.alberonda.tcgstorefront.di

import com.alberonda.tcgstorefront.domain.GameListInteractor
import com.alberonda.tcgstorefront.domain.GameListUseCases
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import com.alberonda.tcgstorefront.model.repositories.GamesRepository
import com.alberonda.tcgstorefront.model.repositories.GamesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun provideGamesRepository(impl: GamesRepositoryImpl): GamesRepository
}