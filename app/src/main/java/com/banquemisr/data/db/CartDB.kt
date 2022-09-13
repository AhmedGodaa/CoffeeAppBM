package com.banquemisr.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.banquemisr.coffeeapp_banquemisr.common.Converters
import com.banquemisr.coffeeapp_banquemisr.domain.model.CoffeeOrder

@Database(
    entities = [CoffeeOrder::class],
    version = 1
)
@TypeConverters(Converters::class)
abstract class CartDB : RoomDatabase() {
    abstract fun getCartDao(): CartDao

    companion object {
        @Volatile
        private var INSTANCE: CartDB? = null

        fun getDatabase(context: Context): CartDB {

            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CartDB::class.java,
                    "cart_db"
                ).build()
                INSTANCE = instance

                instance
            }
        }
    }
}