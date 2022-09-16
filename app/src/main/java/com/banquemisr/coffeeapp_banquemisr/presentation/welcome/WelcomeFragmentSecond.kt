package com.banquemisr.coffeeapp_banquemisr.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banquemisr.coffeeapp_banquemisr.common.openActivity
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentWelcomeThirdBinding
import com.banquemisr.coffeeapp_banquemisr.presentation.signin.SignInActivity
import com.banquemisr.coffeeapp_banquemisr.presentation.signup.SignUpActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeFragmentSecond : Fragment() {
    lateinit var binding: FragmentWelcomeThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeThirdBinding.inflate(layoutInflater)
        binding.btnSignIn.setOnClickListener {
            openActivity(SignInActivity::class.java)
        }
        binding.btnSignUp.setOnClickListener {
            openActivity( SignUpActivity::class.java)
        }
        return binding.root
    }


}