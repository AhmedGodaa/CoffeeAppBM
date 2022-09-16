package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.banquemisr.coffeeapp_banquemisr.databinding.FragmentCartBinding
import kotlinx.coroutines.launch


class CartFragment : Fragment() {
    lateinit var binding: FragmentCartBinding
    private val viewModel: CartViewModel by activityViewModels()
    private lateinit var adapter: CartAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(layoutInflater)
        viewModel.getAllOrders()
        adapter = CartAdapter(viewModel.list)
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.btnOrder.setOnClickListener {
//            viewModel.orderCart()
            lifecycleScope.launch {
                viewModel.deleteAll()
                adapter.setData(emptyList())
            }

        }
        return binding.root
    }


}