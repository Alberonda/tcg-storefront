package com.alberonda.tcgstorefront.domain

import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import javax.inject.Inject

class GameListInteractor
@Inject constructor(
    private val storefrontRepository: StorefrontApiService
) :
    GameListUseCases {

    override suspend fun getGames(): List<Game> {
        return storefrontRepository.getGames().games
    }
}
