package com.banquemisr.coffeeapp_banquemisr.domain.repositories

import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import retrofit2.Response

interface SignInRepo {
   suspend fun signIn(user: UserLogIn) : Response<SignInDto>
}