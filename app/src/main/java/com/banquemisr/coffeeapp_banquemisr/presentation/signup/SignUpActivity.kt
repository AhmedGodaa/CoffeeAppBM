package com.banquemisr.coffeeapp_banquemisr.presentation.signup

import android.os.Bundle
import android.util.Patterns
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.coffeeapp_banquemisr.common.openActivity
import com.banquemisr.coffeeapp_banquemisr.common.showToast
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySignUpBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.User
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignUpRepository
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
        binding.layoutHaveAccount.setOnClickListener {
            openActivity(
                SignInActivity::class.java
            )
        }
        binding.btnSignUp.setOnClickListener {
            if (isValidSignUpDetails()) {
                showToast("Sign up successful")
                signUp()
                openActivity(SignInActivity::class.java)
                finish()
            }

        }
    }

    private fun isValidSignUpDetails(): Boolean {
        return if (binding.inputUsername.text.toString().trim().isEmpty()) {
            binding.inputUsername.error = "Input UserName"
            false
        } else if (binding.inputEmail.editableText.toString().trim().isEmpty()) {
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

        //=======================MOSTAFA============================
        val retroFitSignUp = SignUpRepository()

        retroFitSignUp.signUp(User(
            username =
            binding.inputUsername.text.toString(),
            email =
            binding.inputEmail.editableText.toString(),
            password =
            binding.inputPassword.editableText.toString(),
            ))
        //===================================================
    }
}