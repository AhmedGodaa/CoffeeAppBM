package com.banquemisr.coffeeapp_banquemisr.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityMainBinding
import com.banquemisr.coffeeapp_banquemisr.domain.Menu

class MainActivity : AppCompatActivity(), MenuListener {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val posts: ArrayList<Menu> = ArrayList()
        posts.add(Menu(name = "Espresso", R.drawable.ic_espresso))
        posts.add(Menu(name = "Cappuccino", R.drawable.ic_cappuccino))
        posts.add(Menu(name = "Macciato", R.drawable.ic_macciato))
        posts.add(Menu(name = "Mocha", R.drawable.ic_mocha))
        posts.add(Menu(name = "Latte", R.drawable.ic_latte))
        val adapter = MenuAdapter(posts, this)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun onClick() {

    }
}