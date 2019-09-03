package com.tomlettuces.home.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tomlettuces.home.db.entity.User

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDataBase: RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {

        @Volatile
        var INSTANCE: UserDataBase? = null

        fun getInstance(context: Context): UserDataBase {
            if (INSTANCE == null) {
                synchronized(UserDataBase::class) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context, UserDataBase::class.java,
                            "UserDatabase"
                        ).allowMainThreadQueries().build()
                    }
                }
            }
            return INSTANCE!!
        }

    }

}