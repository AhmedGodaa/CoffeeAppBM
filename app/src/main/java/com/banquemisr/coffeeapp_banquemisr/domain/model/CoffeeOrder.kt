package com.banquemisr.coffeeapp_banquemisr.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(
    tableName = "coffee_order"
)
data class CoffeeOrder(
    @PrimaryKey(autoGenerate = true)

    var id: Int? = null,
    val name: String?,
    val count: Int?,
    val size: String?,
    val sugar: String?,
    val totalPrice: Float?
):Serializable