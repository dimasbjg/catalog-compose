package com.dimdimbjg.catalog_compose.data.source.local.entity

import androidx.annotation.DrawableRes
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cloth")
data class Cloth(
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: String,
    @DrawableRes val iconId: Int
)
