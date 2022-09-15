package com.banquemisr.coffeeapp_banquemisr.common

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants

fun Activity.getAhmedTheme() {
    val preferencesManager =
        PreferencesManager(this)
    val themeBoolean = preferencesManager.getBoolean(Constants.THEME_BOOLEAN)
    if (themeBoolean) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        this.setTheme(R.style.Theme_Night)
    } else {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        this.setTheme(R.style.Theme_Light)
    }
}

fun Fragment.getAhmedTheme() {
    val preferencesManager =
        PreferencesManager(requireContext())
    val themeBoolean = preferencesManager.getBoolean(Constants.THEME_BOOLEAN)
    if (themeBoolean) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        requireContext().setTheme(R.style.Theme_Night)
    } else {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        requireContext().setTheme(R.style.Theme_Light)
    }
}

fun Activity.openActivity(activity: Class<*>?) {
    val intent = Intent(this, activity)
    this.startActivity(intent)
}

fun Fragment.openActivity(activity: Class<*>?) {
    val intent = Intent(requireContext(), activity)
    this.startActivity(intent)
}

fun Activity.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun Fragment.showToast(message: String) {
    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
}


