package com.banquemisr.coffeeapp_banquemisr.data.db

import androidx.annotation.WorkerThread
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder

class CartRepo(private val db: CartDB) {

    suspend fun getAllOrders() = db.getCartDao().getAllOrders()

    @WorkerThread
    suspend fun insertOrder(order: CoffeeOrder) {
        db.getCartDao().insertOrder(order)

    }

}