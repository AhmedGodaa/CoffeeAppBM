package com.banquemisr.coffeeapp_banquemisr.domain.model

import com.google.gson.annotations.SerializedName

data class Coffee(
    val name: String?,
    @SerializedName("productPrice")
    val unitPrice: Int?,
    val icon: Int,

    val ProductImage: String = "",
    val addedToCart: Boolean = false,
    val boughtItemsCount: Int = 0,
    val isAddedToCart: Boolean = false,

    val productId: Int = 0,
    val productName: String = "",
//    val productPrice: Int?,
    val productStockQuantity: Int = 0,
    val productSugarSpoon: Int = 0

    val imageUrl: String? = null,
    val id: Int? = -1
)