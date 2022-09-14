package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.common.Constants.loginFlag
import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.data.remote.ApiClient
import com.banquemisr.data.remote.ApiService
import com.example.example.ProductJsonObject
import com.banquemisr.coffeeapp_banquemisr.common.Constants.coffees
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val apiService: ApiService = ApiClient.retrofitWithClient.create(ApiService::class.java)
    fun getOnlineProducts() {


        apiService.getProducts()?.enqueue(object : Callback<ArrayList<ProductJsonObject>?> {
            override fun onResponse(
                call: Call<ArrayList<ProductJsonObject>?>,
                response: Response<ArrayList<ProductJsonObject>?>
            ) {
                Log.d(TAG, "onResponse: Succeeded")

                if (response.code() == 200) {
                    val responseBody = response.body()!!
                    for (item in responseBody) {
                        val newProduct = item.product!!
                        coffees.add(
                            Coffee(
                                name = newProduct.productName.toString(),
                                icon = R.drawable.ic_espresso,
                                unitPrice = newProduct.productPrice?.toFloat(),
                                id = newProduct.productId!!.toInt(),
                                imageUrl = newProduct.ProductImage.toString()
                            )
                        )
                    }

                }

            }

            override fun onFailure(call: Call<ArrayList<ProductJsonObject>?>, t: Throwable) {
                loginFlag = false
            }
        })

    }

    companion object {
        private val TAG = ProductRepository::class.java.simpleName
    }

}