package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDB
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentCartBinding


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    private lateinit var viewModel: CartViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(layoutInflater)
        val repo = CartRepo(CartDB.getDatabase(requireContext()))
        val cartViewModelProvider = CartViewModelProvider(repo)
        viewModel = ViewModelProvider(this, cartViewModelProvider)[CartViewModel::class.java]
        viewModel.getAllOrders()
        val adapter = CartAdapter(viewModel.list)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        return binding.root
    }


}