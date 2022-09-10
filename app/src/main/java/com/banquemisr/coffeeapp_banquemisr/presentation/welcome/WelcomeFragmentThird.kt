package com.banquemisr.coffeeapp_banquemisr.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentWelcomeSecondBinding
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentWelcomeThirdBinding

class WelcomeFragmentThird : Fragment() {
    lateinit var binding: FragmentWelcomeThirdBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWelcomeThirdBinding.inflate(layoutInflater)
        // Inflate the layout for this fragment
        return binding.root
    }


}