package com.banquemisr.coffeeapp_banquemisr.presentation.menu

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.banquemisr.coffeeapp_banquemisr.presentation.menu.MenuAdapter.MenuViewHolder
import android.view.ViewGroup
import android.view.LayoutInflater
import com.banquemisr.coffeeapp_banquemisr.databinding.ItemContainerMenuBinding
import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.coffeeapp_banquemisr.domain.model.Menu
import com.bumptech.glide.Glide
import java.util.ArrayList

class MenuAdapter(
    private val data: ArrayList<Coffee>,
    private val modelListener: MenuListener,
    private val context: Context
) : RecyclerView.Adapter<MenuViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val binding = ItemContainerMenuBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MenuViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.setMenuData(data[position], position)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class MenuViewHolder(var binding: ItemContainerMenuBinding) :
        RecyclerView.ViewHolder(
            binding.root
        ) {
        fun setMenuData(model: Coffee, position: Int) {
            binding.root.setOnClickListener {
                modelListener.onClick(model)
            }
            binding.imgIcon.setImageResource(model.icon)
            binding.tvTitle.text = model.name

            if(!model.imageUrl.isNullOrEmpty())
            {
                Glide.with(context).load(model.imageUrl).into(binding.imgIcon)
            }
        }
    }
}