package com.dimdimbjg.catalog_compose.data

import androidx.lifecycle.LiveData
import androidx.sqlite.db.SimpleSQLiteQuery
import com.dimdimbjg.catalog_compose.data.source.local.LocalDataSource
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth
import com.dimdimbjg.catalog_compose.db.ClothDao

class Repository constructor(private val localDataSource: LocalDataSource): DataSource {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            localDataSource: LocalDataSource
        ): Repository =
            instance ?: synchronized(this) {
                Repository(localDataSource).apply { instance = this }
            }
    }

    override fun getAll(): LiveData<List<Cloth>> {
        return localDataSource.getAll()
    }

    override fun insert(cloth: Cloth) {
        return localDataSource.insert(cloth)
    }

    override fun delete(cloth: Cloth) {
        return localDataSource.delete(cloth)
    }

    override fun checkFavorite(cloth: Cloth): LiveData<Boolean> {
        return localDataSource.checkFavorite(cloth)
    }


}