package com.banquemisr.coffeeapp_banquemisr.common

//which will appear in the menu and preferences screen
data class Coffee(val name: String, val unitPrice: Double, val imageUrl: String)

//each coffee item after checkout
data class CoffeeOrder(val name: String, val count: Int = 1, val size: Int = -1, val sugar: Int = -1, val totalPrice: Double)

//holds the user's info
data class User(val name: String, val address: String)

//the json body
data class UserOrder(val user: User, val totalPrice: Double, val coffeesList: List<CoffeeOrder>)


/*
JSON example
{
    totalPrice:

    user:{
        name:""
        address:""
    }

    coffeesList:[
        {
            name:"bla"
            count:
            size:
            sugar:
            totalPrice: count * unitPrice
        },
        {
            name:"blabla"
            count:
            size:
            sugar:
            totalPrice: count * unitPrice
        }
    ]


}

 */