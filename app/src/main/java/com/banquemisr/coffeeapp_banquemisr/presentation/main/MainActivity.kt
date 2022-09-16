package com.banquemisr.coffeeapp_banquemisr.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.view.GravityCompat
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.common.showToast
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityMainBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.coffeeapp_banquemisr.presentation.cart.CartFragment
import com.banquemisr.coffeeapp_banquemisr.presentation.menu.MenuListener
import com.banquemisr.coffeeapp_banquemisr.presentation.order.OrderActivity
import com.banquemisr.coffeeapp_banquemisr.presentation.profile.FragmentProfile
import com.banquemisr.coffeeapp_banquemisr.presentation.signin.SignInActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), MenuListener,
    NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var preferenceManager: PreferencesManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showToast(preferenceManager.getString(Constants.KEY_TOKEN).toString())


        binding.floatingActionButton.setOnClickListener {
            val fragmentMain = MainFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, fragmentMain)
            ft.commit()

        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
        bottomNavigationView.background = null
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem? ->
            onNavigationItemSelected(item!!)
        }
        val toggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayout, binding.toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )


        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        binding.navigationView.setNavigationItemSelectedListener(this)


    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_home) {
            val mainFragment = MainFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, mainFragment)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }

        if (item.itemId == R.id.menu_cart) {
            val cartFragment = CartFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, cartFragment)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.menu_profile) {
            val fragmentProfile = FragmentProfile()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, fragmentProfile)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.menu_signOut) {
            preferenceManager.clear()
            Constants.TOKEN = ""
            preferenceManager.putBoolean(Constants.KEY_IS_SIGNED_IN, false)
            val intent = Intent(this, SignInActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(intent)
            finish()
        }



        return true
    }


    private fun changeMode() {
        if (AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES) {
            binding.switch1.setChecked(true)
        } else {
            binding.switch1.setChecked(false)
        }
        binding.switch1.setOnCheckedChangeListener { v ->
            if (v) {
                preferenceManager.putBoolean(
                    Constants.THEME_BOOLEAN,
                    true
                )
                theme
            } else {
                preferenceManager.putBoolean(
                    Constants.THEME_BOOLEAN,
                    false
                )
                theme
            }
        }
    }


    override fun onClick(model: Coffee) {


        val intent = Intent(this, OrderActivity::class.java)
        intent.putExtra(Constants.KEY_MENU_ICON, model.icon)
        intent.putExtra(Constants.KEY_MENU_NAME, model.name)
        intent.putExtra(Constants.KEY_MENU_PRICE, model.unitPrice)
        startActivity(intent)
    }
}