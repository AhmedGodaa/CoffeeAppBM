package com.banquemisr.coffeeapp_banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.domain.model.Coffee

object Constants {


    const val DATABASE_NAME = "note_database"
    const val KEY_THEME = "theme"
    const val BASE_URL = "https://cafe-app-project.herokuapp.com/api/"

    const val KEY_PREFERENCE_NAME = "noteAppPreference"
    const val KEY_IS_SIGNED_IN = "isSignedIn"
    const val THEME_BOOLEAN = "theme_boolean"
    const val KEY_USERNAME = "username"
    const val KEY_TOKEN = "token"
    const val KEY_MENU_ICON = "menuIcon"
    const val KEY_MENU_NAME = "menuName"
    const val KEY_MENU_PRICE = "menuPrice"
    var TOKEN =
        ""
    const val KEY_IMAGE_URL = "imageURL"
    var loginFlag = false
    val coffees: ArrayList<Coffee> = ArrayList()
}
