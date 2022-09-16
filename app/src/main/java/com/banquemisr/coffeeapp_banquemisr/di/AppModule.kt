package com.banquemisr.coffeeapp_banquemisr.di

import android.content.Context
import androidx.room.Room
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDB
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDao
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants
import com.banquemisr.coffeeapp_banquemisr.data.remote.Constants.BASE_URL
import com.banquemisr.coffeeapp_banquemisr.data.repo.SignInRepository
import com.banquemisr.coffeeapp_banquemisr.common.OAuthInterceptor
import com.banquemisr.coffeeapp_banquemisr.common.PreferencesManager
import com.banquemisr.coffeeapp_banquemisr.data.repo.SignUpRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideSignInRepository(apiService: ApiService): SignInRepository {
        return SignInRepository(apiService)

    }

    @Provides
    @Singleton
    fun provideSignUpRepository(apiService: ApiService): SignUpRepository {
        return SignUpRepository(apiService)

    }

    @Provides
    @Singleton
    fun provideCartRepo(dao: CartDao, apiService: ApiService) = CartRepo(dao, apiService)


    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, CartDB::class.java, "cart_db").build()

    @Singleton
    @Provides
    fun provideDao(db: CartDB) = db.getCartDao()

    @Singleton
    @Provides
    fun provideRetrofit(preferencesManager: PreferencesManager): Retrofit {
        val client = OkHttpClient.Builder()
            .addInterceptor(
                OAuthInterceptor(
                    "Bearer",
                    preferencesManager.getString(Constants.KEY_TOKEN).toString()
                )
            )
            .build()
        return Retrofit.Builder().run {
            baseUrl(BASE_URL)
            addConverterFactory(GsonConverterFactory.create())
            client(client)
            build()
        }


    }

    @Singleton
    @Provides
    fun provideApplicationContext(
        @ApplicationContext context: Context
    ) = context


    @Singleton
    @Provides
    fun providePreferenceManager(@ApplicationContext applicationContext: Context) =
        PreferencesManager(applicationContext)


}
