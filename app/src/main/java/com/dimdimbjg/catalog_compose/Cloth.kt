package com.dimdimbjg.catalog_compose

import androidx.annotation.DrawableRes

data class Cloth(
    val name: String,
    val price: String,
    @DrawableRes val iconId: Int
)
