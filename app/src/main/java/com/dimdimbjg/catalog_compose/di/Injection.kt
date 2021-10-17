package com.dimdimbjg.catalog_compose.di

import android.content.Context
import com.dimdimbjg.catalog_compose.data.Repository
import com.dimdimbjg.catalog_compose.data.source.local.LocalDataSource
import com.dimdimbjg.catalog_compose.db.ClothRoomDb

object Injection {
    fun provideRepository(context: Context): Repository {
        val db = ClothRoomDb.getInstance(context)
        val localDataSource = LocalDataSource.getInstance(db.clothDao())
        return Repository.getInstance(localDataSource)
    }
}