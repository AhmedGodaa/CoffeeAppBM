package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import androidx.lifecycle.ViewModel
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignInRepository
import androidx.lifecycle.LiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn


class SignInViewModel : ViewModel() {
    private val signInRepository: SignInRepository = SignInRepository()
    fun getLoginResponseLiveData(user: UserLogIn?): LiveData<SignInDto> {
        return signInRepository.getSignInResponseData(user)
    }

}