package com.banquemisr.data.remote

import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.OkHttpClient
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.OAuthInterceptor

object ApiClient {

//    var retrofit: Retrofit? = null
//        get() {
//            if (field == null) {
//                field = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//            return field
//        }
//        private set
    private const val BASE_URL = "https://cafe-app-project.herokuapp.com/api/"
    val retrofitWithClient: Retrofit
        get() {
            val client = OkHttpClient.Builder()
                .addInterceptor(
                    OAuthInterceptor(
                        "Bearer",
                        Constants.TOKEN
                    )
                )
                .build()
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
        }
}