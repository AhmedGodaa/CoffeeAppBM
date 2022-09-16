package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import com.banquemisr.coffeeapp_banquemisr.data.remote.OrderDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
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

    suspend fun deleteAll() {
        cartRepo.deleteAll()

    }

    fun orderCart(userOrder: UserOrder): LiveData<OrderDto> {
        return cartRepo.orderCart(userOrder)
    }
}