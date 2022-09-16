package com.banquemisr.coffeeapp_banquemisr.data.db

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.OrderDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CartRepo(private val db: CartDB) {
    private val apiService: ApiService = ApiClient.retrofit!!.create(ApiService::class.java)


    suspend fun getAllOrders() = db.getCartDao().getAllOrders()

    @WorkerThread
    suspend fun insertOrder(order: CoffeeOrder) {
        db.getCartDao().insertOrder(order)

    }

    suspend fun deleteAll() {
        db.getCartDao().deleteAllOrders()

    }

    fun orderCart(userOrder: UserOrder): LiveData<OrderDto> {
        val mutableLiveData: MutableLiveData<OrderDto> = MutableLiveData<OrderDto>()
//        apiService.userOrder(userOrder).enqueue(object : Callback<OrderDto?> {
//            override fun onResponse(call: Call<OrderDto?>, response: Response<OrderDto?>) {
//
//                if (response.isSuccessful) {
//                    Log.d(TAG, "onResponse: ")
//                    mutableLiveData.value = response.body()
//                }
//
//            }
//
//            override fun onFailure(call: Call<OrderDto?>, t: Throwable) {
//                Log.d("Failure", "onFailure: ${t.message}")
//            }
//        })
        return mutableLiveData
    }

    companion object {
        private val TAG = CartRepo::class.java.simpleName
    }


}