package com.dimdimbjg.catalog_compose.data

import androidx.lifecycle.LiveData
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth

interface DataSource {
    fun getAll() : LiveData<List<Cloth>>

    fun insert(cloth: Cloth)

    fun delete(cloth: Cloth)

    fun checkFavorite(cloth: Cloth) : LiveData<Boolean>
}