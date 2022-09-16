package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.coffeeapp_banquemisr.data.remote.dto.SignInDto
import com.banquemisr.coffeeapp_banquemisr.data.repo.SignInRepository
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(private val signInRepository: SignInRepository) :
    ViewModel() {

    private var _mutableSignInResponse = MutableLiveData<SignInDto>()
    val signInResponse: LiveData<SignInDto> = _mutableSignInResponse

    fun getLoginResponseLiveData(user: UserLogIn) =

        viewModelScope.launch {
            val response = signInRepository.getSignInResponseData(user)
            if (response.isSuccessful) {
                _mutableSignInResponse.value = response.body()
            }

        }


}