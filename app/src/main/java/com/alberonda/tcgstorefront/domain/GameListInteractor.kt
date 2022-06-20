package com.alberonda.tcgstorefront.domain

import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApiService
import com.alberonda.tcgstorefront.model.repositories.GamesRepository
import javax.inject.Inject

class GameListInteractor
@Inject constructor(
    private val gamesRepository: GamesRepository
) :
    GameListUseCases {

    override suspend fun getGames(): List<Game> {
        return gamesRepository.getGames()
    }
}
