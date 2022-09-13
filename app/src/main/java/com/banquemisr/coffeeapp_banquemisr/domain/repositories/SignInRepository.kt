package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInRepository {
    private val apiService: ApiService = ApiClient.retrofit!!.create(ApiService::class.java)
    fun getSignInResponseData(user: UserLogIn?): LiveData<SignInDto> {
        val mutableLiveData: MutableLiveData<SignInDto> = MutableLiveData<SignInDto>()
        apiService.signIn(user)?.enqueue(object : Callback<SignInDto?> {
            override fun onResponse(call: Call<SignInDto?>, response: Response<SignInDto?>) {
                Log.d(TAG, "onResponse: Succeeded")
                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<SignInDto?>, t: Throwable) {
                Log.d(TAG, t.message!!)
            }
        })
        return mutableLiveData
    }

    companion object {
        private val TAG = SignInRepository::class.java.simpleName
    }

}