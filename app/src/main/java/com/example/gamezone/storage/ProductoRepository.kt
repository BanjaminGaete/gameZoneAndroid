package com.example.gamezone.storage

import kotlinx.coroutines.flow.Flow

class ProductoRepository(private val productDao: ProductDao) {
    suspend fun insertProduct(product: Producto): Long {
        return productDao.insertProduct(product)
    }

    fun getAllProducts(): Flow<List<Producto>> {
        return productDao.getAllProducts()
    }
}
