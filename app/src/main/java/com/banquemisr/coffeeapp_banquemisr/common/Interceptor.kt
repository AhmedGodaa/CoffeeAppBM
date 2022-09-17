package com.banquemisr.coffeeapp_banquemisr.common

import okhttp3.Interceptor

class OAuthInterceptor(private val accessToken: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request =
            request.newBuilder().header("Authorization", "${Constants.BARRIER_TOKEN} $accessToken")
                .build()

        return chain.proceed(request)
    }
}