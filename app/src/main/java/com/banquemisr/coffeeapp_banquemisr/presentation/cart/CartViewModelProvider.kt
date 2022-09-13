package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.banquemisr.data.db.CartRepo

class CartViewModelProvider(
    private val cartRepo: CartRepo
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CartViewModel(cartRepo) as T
    }
}