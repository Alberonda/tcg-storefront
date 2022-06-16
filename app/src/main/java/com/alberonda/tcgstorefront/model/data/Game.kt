package com.alberonda.tcgstorefront.model.data

import com.squareup.moshi.Json

data class Game(
    val id: Int,
    @Json(name = "display_name") val name: String
)
