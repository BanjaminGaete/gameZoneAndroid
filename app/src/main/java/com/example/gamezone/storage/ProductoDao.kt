package com.example.gamezone.storage

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProduct(product: Producto): Long

    @Query("SELECT * FROM producto ORDER BY id DESC")
    fun getAllProducts(): Flow<List<Producto>>
}