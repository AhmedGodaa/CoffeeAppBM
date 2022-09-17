package com.banquemisr.coffeeapp_banquemisr.presentation.welcome

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.banquemisr.coffeeapp_banquemisr.presentation.main.MainActivity
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.presentation.signin.SignInActivity
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.common.openActivity
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityWelcomeBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WelcomeActivity : AppCompatActivity() {
    lateinit var binding: ActivityWelcomeBinding
    private var preferencesManager: PreferencesManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        preferencesManager = PreferencesManager(this)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val dotIndicator = findViewById<DotsIndicator>(R.id.dotIndicator)
        val tabAccessorAdapter = TabAccessorAdapter(supportFragmentManager)
        viewPager.adapter = tabAccessorAdapter
        dotIndicator.setViewPager(viewPager)
        setListeners()
        checkLoginStatus()
    }

    private fun setListeners() {
        binding.btnSkip.setOnClickListener {
           openActivity(
                SignInActivity::class.java
            )
        }

    }
    private fun checkLoginStatus() {
        if (preferencesManager!!.getBoolean(Constants.KEY_IS_SIGNED_IN)) {
            openActivity( MainActivity::class.java)
            finish()
        }
    }

}