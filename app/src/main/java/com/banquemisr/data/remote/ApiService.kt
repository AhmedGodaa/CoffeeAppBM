package com.banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import com.banquemisr.data.remote.dto.SignInDto
import com.banquemisr.data.remote.dto.SignUpDto
import com.example.example.ProductJsonObject
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @POST("auth/login")
    fun signIn(@Body user: UserLogIn?): Call<SignInDto?>?

    @POST("auth/register")
    fun signUp(@Body user: User?): Call<SignUpDto?>?

    @POST("/order")
    fun order(@Body userOrder: UserOrder)

    @GET("cartproduct")
    fun getProducts(): Call<ArrayList<ProductJsonObject>>

}