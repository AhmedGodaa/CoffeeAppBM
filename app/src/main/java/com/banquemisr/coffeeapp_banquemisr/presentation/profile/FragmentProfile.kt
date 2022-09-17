package com.banquemisr.coffeeapp_banquemisr.presentation.profile

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentProfileBinding
import com.banquemisr.coffeeapp_banquemisr.presentation.signin.SignInActivity


class FragmentProfile : Fragment() {
    lateinit var binding: FragmentProfileBinding
    private lateinit var preferenceManager: PreferencesManager


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        preferenceManager = PreferencesManager(requireContext())
        binding.signoutBtn.setOnClickListener {
            preferenceManager.clear()
            Constants.TOKEN = ""
            preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, false)
            val intent = Intent(requireContext(), SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            requireActivity().finish()


        }

        return binding.root
    }


}