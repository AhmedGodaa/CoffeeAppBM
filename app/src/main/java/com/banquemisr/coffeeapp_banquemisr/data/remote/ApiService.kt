package com.banquemisr.coffeeapp_banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import retrofit2.http.POST
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET

interface ApiService {
    @POST("auth/login")
    fun signIn(@Body user: UserLogIn?): Call<SignInDto?>?

    @POST("auth/register")
    fun signUp(@Body user: User?): Call<SignUpDto?>?

    @POST("/order")
    fun order(@Body userOrder: UserOrder)

//    @GET("/product")
//    fun getProducts()
    @POST("/")
    fun userOrder(@Body userOrder: UserOrder): Call<OrderDto>
}