package com.banquemisr.coffeeapp_banquemisr.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    var retrofit: Retrofit? = null
        get() {
            if (field == null) {
                field = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return field
        }
        private set
    private const val BASE_URL = "https://cafe-app-project.herokuapp.com/api/"
}