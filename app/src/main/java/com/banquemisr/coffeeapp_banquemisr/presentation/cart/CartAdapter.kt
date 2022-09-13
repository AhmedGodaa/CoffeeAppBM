package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.banquemisr.coffeeapp_banquemisr.databinding.ItemContainerCoffeeOrderBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import com.banquemisr.coffeeapp_banquemisr.presentation.cart.CartAdapter.CoffeeOrderViewHolder


class CartAdapter(private val data: List<CoffeeOrder>) :
    RecyclerView.Adapter<CoffeeOrderViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoffeeOrderViewHolder {
        val binding = ItemContainerCoffeeOrderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return CoffeeOrderViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CoffeeOrderViewHolder, position: Int) {

        holder.setCoffeeOrderData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class CoffeeOrderViewHolder(var binding: ItemContainerCoffeeOrderBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setCoffeeOrderData(model: CoffeeOrder?) {
            binding.tvTitle.text = "Name: " + model?.name
            binding.tvCount.text = "Count: " + model?.count
            binding.tvTotalPrice.text = "Total: : " + model?.totalPrice
            binding.tvSize.text = "Size: " + model?.size

        }
    }
}