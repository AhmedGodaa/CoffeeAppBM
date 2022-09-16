package com.banquemisr.coffeeapp_banquemisr.data.repo

import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignUpRepo
import retrofit2.Response
import javax.inject.Inject

class SignUpRepository @Inject constructor(private val apiService: ApiService) : SignUpRepo {
    override suspend fun signUp(user: User): Response<SignUpDto> {
        return apiService.signUp(user)
    }


}