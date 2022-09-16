package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder

interface OrderRepo {
    suspend fun orderWithCart(userOrder: UserOrder)
}