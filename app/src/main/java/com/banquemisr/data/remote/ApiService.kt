package com.banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import retrofit2.http.POST
import com.banquemisr.data.remote.dto.SignInDto
import com.banquemisr.data.remote.dto.SignUpDto
import retrofit2.Call
import retrofit2.http.Body

interface ApiService {
    @POST("auth/signin")
    fun signIn(@Body user: User?): Call<SignInDto?>?

    @POST("auth/signup")
    fun signUp(@Body user: User?): Call<SignUpDto?>?
}