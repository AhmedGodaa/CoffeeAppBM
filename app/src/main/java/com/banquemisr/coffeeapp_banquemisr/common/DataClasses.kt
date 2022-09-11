package com.banquemisr.coffeeapp_banquemisr.common

//which will appear in the menu and preferences screen
data class Coffee(val name: String, val unitPrice: Double, val imageUrl: String)

//each coffee item after checkout
data class CoffeeOrder(val name: String, val count: Int, val size: String, val sugar: String, val totalPrice: Int)

//holds the user's info
data class User(val name: String, val address: String)

//the json body
data class UserOrder(val user: User, val totalPrice: Int, val coffeesList: List<CoffeeOrder>)


/*
JSON example
{
    user:{
        name:""
        address:""
    }

    totalPrice:

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