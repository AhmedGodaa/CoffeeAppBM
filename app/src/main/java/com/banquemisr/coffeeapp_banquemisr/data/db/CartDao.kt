package com.banquemisr.coffeeapp_banquemisr.data.db

import androidx.room.*
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder

@Dao
interface CartDao {
    @Query("SELECT * FROM coffee_order")
    suspend fun getAllOrders(): List<CoffeeOrder>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertOrder(article: CoffeeOrder)

    @Query("DELETE FROM coffee_order")
    suspend fun deleteAllOrders()
}