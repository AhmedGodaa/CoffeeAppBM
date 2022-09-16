package com.banquemisr.coffeeapp_banquemisr.data.repo

import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.OrderRepo
import javax.inject.Inject

class OrderRepository : OrderRepo {


    //    fun orderWithCart(userOrder: UserOrder): LiveData<OrderDto> {
//
//        val mutableLiveData = MutableLiveData<OrderDto>()
//
////        apiService.userOrder(userOrder).enqueue(object : Callback<OrderDto?> {
////            override fun onResponse(call: Call<OrderDto?>, response: Response<OrderDto?>) {
////                mutableLiveData.value = response.body()
////            }
////
////            override fun onFailure(call: Call<OrderDto?>, t: Throwable) {
////                Log.d(TAG, t.message!!)
////            }
////        })
//        return mutableLiveData
//    }
    override suspend fun orderWithCart(userOrder: UserOrder) {

    }

}