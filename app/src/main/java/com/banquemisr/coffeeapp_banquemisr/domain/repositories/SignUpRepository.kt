package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import com.banquemisr.data.remote.ApiService
import androidx.lifecycle.LiveData
import com.banquemisr.data.remote.dto.SignUpDto
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.data.remote.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpRepository {
    private val apiService: ApiService = ApiClient.retrofit.create(ApiService::class.java)
    fun signUp(user: User?): LiveData<SignUpDto?> {
        val mutableLiveData = MutableLiveData<SignUpDto?>()
        apiService.signUp(user)!!.enqueue(object : Callback<SignUpDto?> {
            override fun onResponse(call: Call<SignUpDto?>, response: Response<SignUpDto?>) {
                Log.d(TAG, "onResponse: Registered Successfully")
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<SignUpDto?>, t: Throwable) {
                Log.d(TAG, t.message!!)
            }
        })
        return mutableLiveData
    }

    companion object {
        private val TAG = SignUpRepository::class.java.simpleName
    }

}