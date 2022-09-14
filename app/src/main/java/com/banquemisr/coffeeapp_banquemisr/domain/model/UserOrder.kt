package com.banquemisr.coffeeapp_banquemisr.domain.model


data class UserOrder(
    val user: User,
    val totalPrice: Double,
    val coffeesList: List<CoffeeOrder>
)

