package com.banquemisr.coffeeapp_banquemisr.presentation.menu

import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee
import com.banquemisr.coffeeapp_banquemisr.domain.model.Menu

interface MenuListener {
    fun onClick(model: Coffee)
}