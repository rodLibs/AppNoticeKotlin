package com.example.appnewskotlin.data.database.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.appnewskotlin.data.database.dao.ItemDao
import com.example.appnewskotlin.data.database.entity.Item


@Database(entities = arrayOf(Item::class), version = 1)
abstract class DatabaseHelper: RoomDatabase() {


    abstract fun itemDAO(): ItemDao


    companion object {
        private var INSTANCE: DatabaseHelper? = null


        fun getInstance(context: Context): DatabaseHelper? {
            if (INSTANCE == null) {
                synchronized(DatabaseHelper::class) {
                    INSTANCE = Room.databaseBuilder(
                        context, DatabaseHelper::class.java,
                        "neovero_database.db")
                        .build()
                }
            }
            return INSTANCE
        }
    }
}