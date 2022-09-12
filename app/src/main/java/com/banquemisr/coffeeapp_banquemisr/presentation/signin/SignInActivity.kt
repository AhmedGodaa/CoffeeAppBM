package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySignInBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.viewModels.SignInViewModel
import com.banquemisr.coffeeapp_banquemisr.presentation.main.MainActivity

class SignInActivity : AppCompatActivity() {
    lateinit var preferencesManager: PreferencesManager
    lateinit var signInViewModel: SignInViewModel
    lateinit var binding: ActivitySignInBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignInBinding.inflate(layoutInflater)
        setContentView(binding.root)
        signInViewModel = ViewModelProvider(this)[SignInViewModel::class.java]
        preferencesManager = PreferencesManager(this)

    }


    private fun setListeners() {
        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            signIn()
            startActivity(intent)
            finish()
        }
    }


    private fun signIn() {
        val password = binding.inputPassword.text.toString()
        val username = binding.inputEmail.text.toString()
        val user = User(username = username, password = password)
        signInViewModel.getLoginResponseLiveData(user).observe(this) { signInResponse ->
            preferencesManager.putString(Constants.KEY_USERNAME, signInResponse.username)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}