package com.alberonda.tcgstorefront.domain

import com.alberonda.tcgstorefront.model.data.Game

interface GameListUseCases {
    suspend fun getGames(): List<Game>
}