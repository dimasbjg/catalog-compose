package com.dimdimbjg.catalog_compose.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import androidx.sqlite.db.SupportSQLiteQuery
import com.dimdimbjg.catalog_compose.data.source.local.entity.Cloth


@Dao
interface ClothDao {
    @Query("SELECT * from cloth")
    fun getAll(): LiveData<List<Cloth>>

    @Query("SELECT * from cloth where id = :id")
    fun getById(id: Int): Cloth?

    @Insert(onConflict = REPLACE)
    fun insert(item: Cloth)

    @Delete
    fun delete(item: Cloth)

    @RawQuery(observedEntities = [Cloth::class])
    fun checkFavorite(query: SupportSQLiteQuery): LiveData<Boolean>
}