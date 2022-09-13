package com.banquemisr.coffeeapp_banquemisr.domain.model


data class CoffeeOrder(
    val name: String?,
    val count: Int?,
    val size: Int?,
    val sugar: Int?,
    val totalPrice: Double?
)