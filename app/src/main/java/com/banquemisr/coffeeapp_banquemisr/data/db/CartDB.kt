package com.banquemisr.coffeeapp_banquemisr.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder

@Database(
    entities = [CoffeeOrder::class],
    version = 1,
    exportSchema = false
)

abstract class CartDB : RoomDatabase() {
    abstract fun getCartDao(): CartDao

}