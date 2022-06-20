package com.alberonda.tcgstorefront.model.repositories

import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import javax.inject.Inject

class GamesRepositoryImpl
@Inject constructor(
    private val storefrontApiService: StorefrontApiService
): GamesRepository {
    override suspend fun getGames() = storefrontApiService.getGames().games
}