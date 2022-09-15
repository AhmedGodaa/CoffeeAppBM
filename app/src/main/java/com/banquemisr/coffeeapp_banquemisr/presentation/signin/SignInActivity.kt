package com.banquemisr.coffeeapp_banquemisr.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.common.showToast
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySignInBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserLogIn
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
            if (isValidSignInDetails()) {
                signIn()
            }
        }

    }

    private fun isValidSignInDetails(): Boolean {
        return if (binding.inputEmail.editableText.toString().trim().isEmpty()) {
            showToast("Enter Email")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.editableText.toString())
                .matches()
        ) {
            showToast("Enter valid Email")
            false
        } else if (binding.inputPassword.editableText.toString().trim().isEmpty()) {
            showToast("Enter Password")
            false
        } else {
            true
        }
    }

    private fun signIn() {
        val password = binding.inputPassword.text.toString()
        val email = binding.inputEmail.text.toString()
        val user = UserLogIn(email = email, password = password)

        signInViewModel.getLoginResponseLiveData(user).observe(this) {
            if (Constants.loginFlag) {
                preferencesManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true)
                val intent = Intent(this, MainActivity::class.java)
                preferencesManager.putBoolean(Constants.KEY_IS_SIGNED_IN, true)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }
        }

    }


}
