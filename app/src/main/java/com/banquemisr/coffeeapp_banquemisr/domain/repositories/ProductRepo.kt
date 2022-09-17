package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import com.example.example.Product
import retrofit2.Response

interface ProductRepo {
    suspend fun getProducts(): Response<List<Product>>
}