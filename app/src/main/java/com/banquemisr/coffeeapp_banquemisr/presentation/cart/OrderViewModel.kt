package com.banquemisr.coffeeapp_banquemisr.presentation.cart

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDB
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import com.banquemisr.coffeeapp_banquemisr.data.remote.OrderDto
import com.banquemisr.coffeeapp_banquemisr.domain.model.UserOrder
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.OrderRepository


class OrderViewModel(private val db: CartDB) : ViewModel() {
    private val orderRepository: OrderRepository = OrderRepository()
    private val cartRepo: CartRepo = CartRepo(db)



//    fun orderWithCart(userOrder: UserOrder): LiveData<OrderDto> {
//        return orderRepository.orderWithCart(userOrder)
//
//    }



}