package com.alberonda.tcgstorefront.domain

import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApiService

class GameListInteractor(private val storefrontRepository: StorefrontApiService) :
    GameListUseCases {

    override suspend fun getGames(): List<Game> {
        return storefrontRepository.getGames().games
    }
}
