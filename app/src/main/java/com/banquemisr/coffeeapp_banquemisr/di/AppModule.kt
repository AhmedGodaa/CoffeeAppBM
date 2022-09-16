package com.banquemisr.coffeeapp_banquemisr.di

import android.content.Context
import androidx.room.Room
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDB
import com.banquemisr.coffeeapp_banquemisr.data.db.CartDao
import com.banquemisr.coffeeapp_banquemisr.data.db.CartRepo
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiClient
import com.banquemisr.coffeeapp_banquemisr.data.remote.ApiService
import com.banquemisr.coffeeapp_banquemisr.domain.repositories.SignInRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    //            private val signInRepository: SignInRepository = SignInRepository()
    @Provides
    @Singleton
    fun provideSignInRepository(apiService: ApiService): SignInRepository {
        return SignInRepository(apiService)

    }

    @Provides
    @Singleton
    fun provideCartRepo(dao: CartDao, apiService: ApiService) = CartRepo(dao, apiService)


    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiClient.retrofit!!.create(ApiService::class.java)
    }


    @Singleton
    @Provides
    fun provideYourDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(app, CartDB::class.java, "cart_db").build()

    @Singleton
    @Provides
    fun provideDao(db: CartDB) = db.getCartDao()
}
