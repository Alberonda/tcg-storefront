package com.alberonda.tcgstorefront.model.network.responses

import com.alberonda.tcgstorefront.model.data.Game
import com.squareup.moshi.Json

data class GetGamesResponse(
    @Json(name = "array") val games: List<Game>
)