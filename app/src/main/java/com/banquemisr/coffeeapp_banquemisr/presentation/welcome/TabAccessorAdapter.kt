package com.banquemisr.coffeeapp_banquemisr.presentation.welcome

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class TabAccessorAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> WelcomeFragmentFirst()
            1 -> WelcomeFragmentThird()
            else -> WelcomeFragmentFirst()
        }
    }

    override fun getCount(): Int {
        return 2
    }


}