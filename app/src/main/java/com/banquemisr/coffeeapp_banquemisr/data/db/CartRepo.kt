package com.banquemisr.coffeeapp_banquemisr.data.db

import androidx.annotation.WorkerThread
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import javax.inject.Inject


class CartRepo @Inject constructor(
    private val dao: CartDao,
    private val apiService: ApiService
) {


    suspend fun getAllOrders() = dao.getAllOrders()

    @WorkerThread
    suspend fun insertOrder(order: CoffeeOrder) {
        dao.insertOrder(order)

    }

    suspend fun deleteAll() {
        dao.deleteAllOrders()

    }
//
//    fun orderCart(userOrder: UserOrder): LiveData<OrderDto> {
//        val mutableLiveData: MutableLiveData<OrderDto> = MutableLiveData<OrderDto>()
//        GlobalScope.launch {
//            apiService.userOrder(userOrder)
//        }
////        apiService.userOrder(userOrder).enqueue(object : Callback<OrderDto?> {
////            override fun onResponse(call: Call<OrderDto?>, response: Response<OrderDto?>) {
////
////                if (response.isSuccessful) {
////                    Log.d(TAG, "onResponse: ")
////                    mutableLiveData.value = response.body()
////                }
////
////            }
////
////            override fun onFailure(call: Call<OrderDto?>, t: Throwable) {
////                Log.d("Failure", "onFailure: ${t.message}")
////            }
////        })
//        return mutableLiveData
//    }


}