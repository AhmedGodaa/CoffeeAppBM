package com.banquemisr.coffeeapp_banquemisr.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentProfileBinding


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)

        return binding.root
    }


}