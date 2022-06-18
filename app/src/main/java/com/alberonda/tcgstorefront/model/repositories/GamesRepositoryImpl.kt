package com.alberonda.tcgstorefront.model.repositories

import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(): GamesRepository {
    override suspend fun getGames() = emptyList<Game>()
}