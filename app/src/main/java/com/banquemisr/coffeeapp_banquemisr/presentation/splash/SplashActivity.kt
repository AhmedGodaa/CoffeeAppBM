package com.banquemisr.coffeeapp_banquemisr.presentation.splash

import android.os.Bundle
import android.view.animation.AnimationUtils
import androidx.appcompat.app.AppCompatActivity
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.common.openActivity
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySplashBinding
import com.banquemisr.coffeeapp_banquemisr.presentation.main.MainActivity
import com.banquemisr.coffeeapp_banquemisr.presentation.welcome.WelcomeActivity
import java.util.*

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private lateinit var preferenceManager: PreferencesManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferenceManager = PreferencesManager(applicationContext)
        val logoAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_logo)
        binding.logo.animation = logoAnimation
        delay()
    }

    private fun delay() {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                setListeners()
                finish()
            }
        }, 2500)
    }

    private fun setListeners() {
        if (preferenceManager.getBoolean(Constants.KEY_IS_SIGNED_IN)) {
            openActivity(MainActivity::class.java)
        } else {
            openActivity(WelcomeActivity::class.java)
        }
    }
}