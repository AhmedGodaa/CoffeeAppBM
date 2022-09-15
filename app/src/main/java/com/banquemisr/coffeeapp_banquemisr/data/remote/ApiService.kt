package com.banquemisr.coffeeapp_banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import retrofit2.http.POST
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.data.remote.dto.SignInDto
import com.banquemisr.data.remote.dto.SignUpDto
import com.example.example.Product
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

//    @GET("/product")
//    fun getProducts()
    @POST("/")
    fun userOrder(@Body userOrder: UserOrder): Call<OrderDto>

    @POST("/")
    fun getAll(@Body userOrder: UserOrder): Call<OrderDto>
    @GET("product")
    fun getProducts(): Call<ArrayList<Product>>

}