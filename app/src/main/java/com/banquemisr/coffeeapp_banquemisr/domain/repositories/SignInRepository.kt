package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants.loginFlag
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class SignInRepository @Inject constructor(private val apiService: ApiService) {



    fun getSignInResponseData(user: UserLogIn?): LiveData<SignInDto> {

        val mutableLiveData: MutableLiveData<SignInDto> = MutableLiveData<SignInDto>()
        apiService.signIn(user).enqueue(object : Callback<SignInDto?> {
            override fun onResponse(call: Call<SignInDto?>, response: Response<SignInDto?>) {
                Log.d(TAG, "onResponse: Succeeded")
                if (response.code() == 200) {
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