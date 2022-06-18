package com.alberonda.tcgstorefront.di

import com.alberonda.tcgstorefront.model.network.RetrofitService
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object ApiModule {

    @Provides
    fun provideStorefrontApiService(): StorefrontApiService = RetrofitService.retrofitService
}