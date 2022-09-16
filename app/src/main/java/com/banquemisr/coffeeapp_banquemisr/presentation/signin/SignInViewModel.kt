package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import androidx.lifecycle.ViewModel
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignInRepository
import androidx.lifecycle.LiveData
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInRepository: SignInRepository) :
    ViewModel() {
    fun getLoginResponseLiveData(user: UserLogIn?): LiveData<SignInDto> {
        return signInRepository.getSignInResponseData(user)
    }

}