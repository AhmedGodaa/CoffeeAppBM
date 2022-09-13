package com.banquemisr.data.remote

import retrofit2.Retrofit
import com.banquemisr.data.remote.ApiClient
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
    private const val BASE_URL = "http://10.0.2.2:8080/api/"
}