package com.banquemisr.coffeeapp_banquemisr.domain.model

data class Coffee(
    val name: String?,
    val unitPrice: Float?,
    val icon: Int,
    val imageUrl: String? = null,
    val id: Int? = -1
)