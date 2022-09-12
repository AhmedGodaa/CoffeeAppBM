package com.banquemisr.coffeeapp_banquemisr.domain.viewModels

import androidx.lifecycle.ViewModel
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignInRepository
import androidx.lifecycle.LiveData
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.data.remote.dto.SignInDto

class SignInViewModel : ViewModel() {
    private val signInRepository: SignInRepository = SignInRepository()
    fun getLoginResponseLiveData(user: User?): LiveData<SignInDto> {
        return signInRepository.getSignInResponseData(user)
    }

}