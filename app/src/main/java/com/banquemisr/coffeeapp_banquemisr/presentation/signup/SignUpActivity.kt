package com.banquemisr.coffeeapp_banquemisr.presentation.signup

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.common.Common.Companion.openActivity
import com.banquemisr.coffeeapp_banquemisr.common.Common.Companion.showToast
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySignUpBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.viewModels.SignUpViewModel
import com.banquemisr.coffeeapp_banquemisr.presentation.signin.SignInActivity

class SignUpActivity : AppCompatActivity() {
    lateinit var binding: ActivitySignUpBinding
    lateinit var viewModel: SignUpViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
        viewModel = ViewModelProvider(this)[SignUpViewModel::class.java]
        setListeners()

    }

    private fun setListeners() {
        binding.layoutHaveAccount.setOnClickListener { v ->
            openActivity(
                applicationContext,
                SignInActivity::class.java
            )
        }
        binding.btnSignUp.setOnClickListener {
            if (isValidSignUpDetails()) {
                signUp()
            }
        }
    }

    private fun isValidSignUpDetails(): Boolean {
        return if (binding.inputUsername.text.toString().trim().isEmpty()) {
            showToast(this, "Enter Name")
            false
        } else if (binding.inputEmail.editableText.toString().trim().isEmpty()) {
            showToast(this, "Enter Email")
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.inputEmail.editableText.toString())
                .matches()
        ) {
            showToast(this, "Enter valid Email")
            false
        } else if (binding.inputPassword.editableText.toString().trim().isEmpty()) {
            showToast(this, "Enter Password")
            false
        } else {
            true
        }
    }


    private fun signUp() {
        viewModel.signUp(
            User(
                username =
                binding.inputUsername.text.toString(),
                email =
                binding.inputEmail.editableText.toString(),
                password =
                binding.inputPassword.editableText.toString(),

                )
        )
        openActivity(this, SignInActivity::class.java)
    }
}