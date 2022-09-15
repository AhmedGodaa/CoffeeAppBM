package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.common.Constants.loginFlag
import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.common.Constants.coffees
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.example.example.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val apiService: ApiService = ApiClient.retrofitWithClient.create(ApiService::class.java)
    fun getOnlineProducts() {


        apiService.getProducts().enqueue(object : Callback<ArrayList<Product>?> {
            override fun onResponse(
                call: Call<ArrayList<Product>?>,
                response: Response<ArrayList<Product>?>
            ) {
                Log.d(TAG, "onResponse: Succeeded")

                if (response.code() == 200) {
                    val responseBody = response.body()!!
                    for (item in responseBody) {
                        coffees.add(
                            Coffee(
                                name = item.productName.toString(),
                                icon = R.drawable.ic_espresso,
                                unitPrice = item.productPrice,
                                id = item.productId!!.toInt(),
                                imageUrl = item.ProductImage.toString()
                            )
                        )
                    }

                }

            }

            override fun onFailure(call: Call<ArrayList<Product>?>, t: Throwable) {
                loginFlag = false
            }
        })

    }

    companion object {
        private val TAG = ProductRepository::class.java.simpleName
    }

}