package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.common.Constants.loginFlag
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.data.remote.ApiClient
import com.banquemisr.data.remote.ApiService
import com.banquemisr.data.remote.dto.SignInDto

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignInRepository {
    private val apiService: ApiService = ApiClient.getRetrofit().create(ApiService::class.java)
    fun getSignInResponseData(user: UserLogIn?): LiveData<SignInDto> {
        val mutableLiveData: MutableLiveData<SignInDto> = MutableLiveData<SignInDto>()
        apiService.signIn(user)?.enqueue(object : Callback<SignInDto?> {
            override fun onResponse(call: Call<SignInDto?>, response: Response<SignInDto?>) {
                Log.d(TAG, "onResponse: Succeeded")

                if(response.code() == 200)
                {
                    loginFlag = true
                }

                mutableLiveData.value = response.body()
            }

            override fun onFailure(call: Call<SignInDto?>, t: Throwable) {
                loginFlag = false
            }
        })
        return mutableLiveData
    }

    companion object {
        private val TAG = SignInRepository::class.java.simpleName
    }

}