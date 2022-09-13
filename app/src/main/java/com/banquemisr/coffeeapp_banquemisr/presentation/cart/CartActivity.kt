package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.banquemisr.coffeeapp_banquemisr.R
import com.banquemisr.coffeeapp_banquemisr.databinding.ActivityCartBinding
import com.banquemisr.coffeeapp_banquemisr.presentation.menu.MenuAdapter
import com.banquemisr.data.db.CartDB
import com.banquemisr.data.db.CartRepo

class CartActivity : AppCompatActivity() {
    lateinit var binding: ActivityCartBinding
    private lateinit var viewModel: CartViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val repo = CartRepo(CartDB.getDatabase(this))
        val cartViewModelProvider = CartViewModelProvider(repo)
        viewModel = ViewModelProvider(this, cartViewModelProvider)[CartViewModel::class.java]
        val adapter = CartAdapter(viewModel.list)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}