package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import retrofit2.Response

interface SignUpRepo {
    suspend fun signUp(user : User): Response<SignUpDto>
}