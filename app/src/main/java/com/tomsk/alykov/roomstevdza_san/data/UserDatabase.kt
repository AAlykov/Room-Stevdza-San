package com.tomsk.alykov.roomstevdza_san.data

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room

//содеержит базу данных и служит основной точкой подключения. Должно быть abstract

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase: RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserDatabase? = null

        fun getDatabase(context: Context): UserDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}