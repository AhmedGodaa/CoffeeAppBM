package com.banquemisr.coffeeapp_banquemisr.domain.viewModels

import androidx.lifecycle.ViewModel
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignUpRepository
import androidx.lifecycle.LiveData
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.data.remote.dto.SignUpDto

class SignUpViewModel : ViewModel() {
    private val signUpRepository: SignUpRepository = SignUpRepository()
    fun signUp(user: User?): LiveData<SignUpDto?> {
        return signUpRepository.signUp(user)
    }

}