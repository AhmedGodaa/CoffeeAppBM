package com.banquemisr.coffeeapp_banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import com.example.example.Product
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    fun signIn(@Body user: UserLogIn?): Call<SignInDto?>?

    @POST("auth/register")
    fun signUp(@Body user: User?): Call<SignUpDto?>?


    @POST("/")
    fun userOrder(@Body userOrder: UserOrder): Call<OrderDto>

    @GET("product")
    fun getProducts(): Call<ArrayList<Product>>

}