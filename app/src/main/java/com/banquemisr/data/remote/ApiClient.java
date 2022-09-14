package com.banquemisr.data.remote;

import com.banquemisr.coffeeapp_banquemisr.common.Constants;
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.OAuthInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://cafe-app-project.herokuapp.com/api/";



    public static Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;

    }

    public static Retrofit getRetrofitWithClient() {

        OkHttpClient client =  new OkHttpClient.Builder()
                .addInterceptor(new OAuthInterceptor("Bearer", Constants.TOKEN))
                .build();

        Retrofit retrofitWithClient = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();


        return retrofitWithClient;

    }

}
