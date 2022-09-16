package com.banquemisr.coffeeapp_banquemisr.data.repo

import com.banquemisr.coffeeapp_banquemisr.domain.repositories.ProductRepo

class ProductRepository : ProductRepo {
    fun getOnlineProducts() {


//        apiService.getProducts().enqueue(object : Callback<ArrayList<Product>?> {
//            override fun onResponse(
//                call: Call<ArrayList<Product>?>,
//                response: Response<ArrayList<Product>?>
//            ) {
//                Log.d(TAG, "onResponse: Succeeded")
//
//                if (response.code() == 200) {
//                    val responseBody = response.body()!!
//                    for (item in responseBody) {
//                        coffees.add(
//                            Coffee(
//                                name = item.productName.toString(),
//                                icon = R.drawable.ic_espresso,
//                                unitPrice = item.productPrice,
//                                id = item.productId!!.toInt(),
//                                imageUrl = item.ProductImage.toString()
//                            )
//                        )
//                    }
//
//                }
//
//            }
//
//            override fun onFailure(call: Call<ArrayList<Product>?>, t: Throwable) {
//                loginFlag = false
//            }
//        })

    }


}