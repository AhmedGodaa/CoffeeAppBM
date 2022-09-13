package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.OrderDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OrderRepository {
    private val apiService: ApiService = ApiClient.retrofit!!.create(ApiService::class.java)

    fun orderWithCart(userOrder: UserOrder): LiveData<OrderDto> {

        val mutableLiveData = MutableLiveData<OrderDto>()

        apiService.userOrder(userOrder).enqueue(object : Callback<OrderDto?> {
            override fun onResponse(call: Call<OrderDto?>, response: Response<OrderDto?>) {
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<OrderDto?>, t: Throwable) {
                Log.d(TAG, t.message!!)
            }
        })
        return mutableLiveData
    }

    companion object {
        private val TAG = SignUpRepository::class.java.simpleName
    }

}