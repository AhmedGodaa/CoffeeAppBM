package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.common.Common
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
        setListeners()

    }


    private fun setListeners() {

        binding.btnSignIn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
//            if (isValidSignInDetails()) {
//                signIn()
//            }
            startActivity(intent)
            finish()
        }

    }

    private fun isValidSignInDetails(): Boolean {
        return if (binding.inputEmail.editableText.toString().trim().isEmpty()) {
            Common.showToast(this, "Enter Email")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.editableText.toString())
                .matches()
        ) {
            Common.showToast(this, "Enter valid Email")
            false
        } else if (binding.inputPassword.editableText.toString().trim().isEmpty()) {
            Common.showToast(this, "Enter Password")
            false
        } else {
            true
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