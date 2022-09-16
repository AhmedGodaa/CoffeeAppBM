package com.banquemisr.coffeeapp_banquemisr.data.repo


import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignInRepo

import retrofit2.Response
import javax.inject.Inject

class SignInRepository @Inject constructor(private val apiService: ApiService) : SignInRepo {



    override suspend fun getSignInResponseData(user: UserLogIn): Response<SignInDto> {
        return apiService.signIn(user)
    }

}