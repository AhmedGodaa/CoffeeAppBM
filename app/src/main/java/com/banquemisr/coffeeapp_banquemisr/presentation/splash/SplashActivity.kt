package com.banquemisr.coffeeapp_banquemisr.presentation.splash

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivitySplashBinding
import com.banquemisr.coffeeapp_banquemisr.presentation.welcome.WelcomeActivity

class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        playVideo()
        binding.imageView.setOnClickListener {
            val intent = Intent(this, WelcomeActivity::class.java)
            startActivity(intent)
            finish()
        }

    }


    override fun onResume() {
        super.onResume()
        playVideo()

    }

    private fun playVideo() {
        val uri = Uri.parse("android.resource://" + packageName + "/" + R.raw.vid_splash)
        binding.videoView.setVideoURI(uri)
        binding.videoView.start()
        binding.videoView.setOnCompletionListener { binding.videoView.start() }

    }

}