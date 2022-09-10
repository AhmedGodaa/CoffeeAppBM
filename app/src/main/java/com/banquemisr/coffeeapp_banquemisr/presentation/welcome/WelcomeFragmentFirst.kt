package com.banquemisr.coffeeapp_banquemisr.presentation.welcome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityWelcomeBinding


class WelcomeFragmentFirst : Fragment() {
    lateinit var binding: ActivityWelcomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ActivityWelcomeBinding.inflate(layoutInflater)

        return binding.root
    }


}