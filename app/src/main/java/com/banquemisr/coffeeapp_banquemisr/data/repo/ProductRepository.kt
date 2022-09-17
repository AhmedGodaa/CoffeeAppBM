package com.banquemisr.coffeeapp_banquemisr.data.repo

import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.ProductRepo
import com.example.example.Product
import retrofit2.Response
import javax.inject.Inject

class ProductRepository @Inject constructor(private val apiService: ApiService) : ProductRepo {

    override suspend fun getProducts(): Response<List<Product>> {
        return apiService.getProducts()
    }




}