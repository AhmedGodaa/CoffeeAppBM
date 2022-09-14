package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CartViewModel(
    private val cartRepo: CartRepo
) : ViewModel() {
    private val _list = mutableListOf<CoffeeOrder>()
    val list: List<CoffeeOrder> = _list



     fun getAllOrders() {
        viewModelScope.launch(Dispatchers.Default) {
            cartRepo.getAllOrders().forEach {
                _list.add(it)

            }
        }

    }

    suspend fun insertOrder(order: CoffeeOrder) =
        withContext(Dispatchers.Main) {
            cartRepo.insertOrder(order)

        }
}