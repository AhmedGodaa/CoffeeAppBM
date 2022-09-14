package com.banquemisr.coffeeapp_banquemisr.presentation.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
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


//    private fun changeMode() {
//        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
//            binding!!.switch1.setChecked(true)
//        } else {
//            binding!!.switch1.setChecked(false)
//        }
//        binding!!.switch1.setOnCheckedChangeListener { v ->
//            if (v) {
//                preferencesManager?.putBoolean(
//                    Constants.THEME_BOOLEAN,
//                    true
//                )
//                getTheme(applicationContext)
//            } else {
//                preferencesManager?.putBoolean(
//                    Constants.THEME_BOOLEAN,
//                    false
//                )
//                getTheme(applicationContext)
//            }
//        }
//    }
//


}