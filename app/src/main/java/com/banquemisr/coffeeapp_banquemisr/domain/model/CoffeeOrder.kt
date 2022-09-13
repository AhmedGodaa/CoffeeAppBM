package com.banquemisr.coffeeapp_banquemisr.domain.model

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey

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
)