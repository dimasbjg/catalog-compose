package com.dimdimbjg.catalog_compose.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth


const val DB_NAME = "CLOTH_DB.db"

@Database(entities = [Cloth::class], version = 1, exportSchema = false)
abstract class ClothRoomDb: RoomDatabase() {

    abstract fun clothDao(): ClothDao

    companion object{
        @Volatile
        private var INSTANCE: ClothRoomDb? = null

        fun getInstance(context: Context): ClothRoomDb =
            INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    ClothRoomDb::class.java,
                    DB_NAME
                ).build().apply {
                    INSTANCE = this
                }
            }
    }

}