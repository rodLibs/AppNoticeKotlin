package com.example.appnewskotlin.data.database

import androidx.room.*
import com.example.appnewskotlin.data.model.Item

@Dao
interface ItemDao {

    @Insert
    fun insert(news: Item?)

    @Update
    fun update(news: Item?)

    @Delete
    fun delete(news: Item?)

    @Query("SELECT * FROM item")
    fun getAllNews(): List<Item>?

    @Query("SELECT * FROM item where itemId = :id")
    fun getById(id: Long): Item?

    @Query("DELETE FROM item")
    fun deleteTableNews()
}