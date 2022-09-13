package com.banquemisr.coffeeapp_banquemisr.presentation.main

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.common.Constants
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityMainBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.coffeeapp_banquemisr.presentation.menu.MenuAdapter
import com.banquemisr.coffeeapp_banquemisr.presentation.menu.MenuListener
import com.banquemisr.coffeeapp_banquemisr.presentation.order.OrderActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), MenuListener,
    NavigationView.OnNavigationItemSelectedListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
//        getAhmedTheme()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.background = null
        bottomNavigationView.menu.getItem(3).isEnabled = false
        bottomNavigationView.setOnNavigationItemSelectedListener { item: MenuItem? ->
            onNavigationItemSelected(
                item!!
            )
        }

        val coffees: ArrayList<Coffee> = ArrayList()
        coffees.add(Coffee(name = "Espresso", icon = R.drawable.ic_espresso, unitPrice = 10.0f))
        coffees.add(Coffee(name = "Cappuccino", icon = R.drawable.ic_cappuccino, unitPrice = 15.0f))
        coffees.add(Coffee(name = "Macciato", icon = R.drawable.ic_macciato, unitPrice = 25.0f))
        coffees.add(Coffee(name = "Mocha", icon = R.drawable.ic_mocha, unitPrice = 35.0f))
        coffees.add(Coffee(name = "Latte", icon = R.drawable.ic_latte, unitPrice = 40.0f))
        val adapter = MenuAdapter(coffees, this)
//        binding.recyclerView.setHasFixedSize(true)
//        binding.recyclerView.adapter = adapter
//        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onClick(model: Coffee) {
        val intent = Intent(this, OrderActivity::class.java);
        intent.putExtra(Constants.KEY_MENU_ICON, model.icon)
        intent.putExtra(Constants.KEY_MENU_NAME, model.name)
        intent.putExtra(Constants.KEY_MENU_PRICE, model.unitPrice)
        startActivity(intent)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_home) {
            val homeFragment = HomeFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, mainFragment)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.menu_cart) {
            val usersFragment = UsersFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, usersFragment)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.menu_profile) {
            val groupsFragment = GroupsFragment()
            val fm = supportFragmentManager
            val ft = fm.beginTransaction()
            ft.replace(R.id.fragmentContainer, groupsFragment)
            ft.commit()
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }


        if (item.itemId == R.id.menu_home) {
            val intent = Intent(applicationContext, TimelineActivity::class.java)
            startActivity(intent)
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        }
        if (item.itemId == R.id.menu_logout) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            signOut()
        }

        return true
    }
}