package com.banquemisr.coffeeapp_banquemisr.presentation.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignUpDto
import com.banquemisr.coffeeapp_banquemisr.data.repo.SignUpRepository
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(private val signUpRepository: SignUpRepository) :
    ViewModel() {

    private var _mutableSignUpResponse = MutableLiveData<SignUpDto>()
    val mutableSignInResponse: LiveData<SignUpDto> = _mutableSignUpResponse

    fun signUp(user: User) = viewModelScope.launch {
        val response = signUpRepository.signUp(user)
        if (response.isSuccessful) {
            _mutableSignUpResponse.value = response.body()

        }

    }


}