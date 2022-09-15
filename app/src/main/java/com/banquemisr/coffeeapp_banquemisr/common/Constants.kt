package com.banquemisr.coffeeapp_banquemisr.common

import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee

object Constants {

    const val NUMBER_OF_THREADS = 4
    const val DATABASE_NAME = "note_database"
    const val KEY_THEME = "theme"
    const val KEY_PREFERENCE_NAME = "noteAppPreference"
    const val KEY_IS_SIGNED_IN = "isSignedIn"
    const val THEME_BOOLEAN = "theme_boolean"
    const val KEY_USERNAME = "username"
    const val KEY_MENU_ICON = "menuIcon"
    const val KEY_MENU_NAME = "menuName"
    const val KEY_MENU_PRICE = "menuPrice"
    const val TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJmYWR5IiwiZXhwIjoxNjYzNDU5MjAwLCJpYXQiOjE2NjMxNzc4MTQsImF1dGhvcml0aWVzIjpbImN1c3RvbWVyIl19.qEitW3XOk6LrPN0xT8pmM4IcmgaI6I0Bsjs-OIVb80c"
    var loginFlag = false
    val coffees: ArrayList<Coffee> = ArrayList()
}
