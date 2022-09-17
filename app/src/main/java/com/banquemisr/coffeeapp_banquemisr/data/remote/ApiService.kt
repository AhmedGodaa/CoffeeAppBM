package com.banquemisr.coffeeapp_banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import com.example.example.Product
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("auth/login")
    suspend fun signIn(@Body user: UserLogIn?): Response<SignInDto>

    @POST("auth/register")
    suspend fun signUp(@Body user: User?): Response<SignUpDto>


    @POST("order")
    suspend fun userOrder(@Body userOrder: UserOrder): Response<OrderDto>

    @GET("product")
    suspend fun getProducts(): Response<List<Product>>

}