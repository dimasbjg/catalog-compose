package com.dimdimbjg.catalog_compose.data.source.local

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.dimdimbjg.catalog_compose.data.DataSource
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth
import com.dimdimbjg.catalog_compose.db.ClothDao

class LocalDataSource private constructor(private val clothDao: ClothDao){

    companion object {
        private var INSTANCE: LocalDataSource? = null

        fun getInstance(clothDao: ClothDao): LocalDataSource {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: LocalDataSource(clothDao)
            }
        }
    }

    fun getAll(): LiveData<List<Cloth>> = clothDao.getAll()

    fun insert(cloth: Cloth) {
        clothDao.insert(cloth)
    }

    fun delete(cloth: Cloth) {
        clothDao.delete(cloth)
    }

    fun checkFavorite(cloth: Cloth): LiveData<Boolean> {
        val query = SimpleSQLiteQuery("SELECT EXISTS(SELECT * FROM cloth where id = ${cloth.id})")
        return clothDao.checkFavorite(query)
    }


}