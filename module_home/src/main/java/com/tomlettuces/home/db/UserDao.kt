package com.tomlettuces.home.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.tomlettuces.home.db.entity.User

@Dao
interface UserDao {

    @Query("SELECT * FROM user")
    fun loadAll(): List<User>

    @Query("SELECT * FROM user WHERE id IN (:userIds)")
    fun loadAllByUserId(vararg userIds: Int): List<User>

    @Query("SELECT * FROM user WHERE name Like :name AND age = :age LIMIT 1")
    fun loadOneByNameAndAge(name: String, age: Int): List<User>

    @Insert
    fun insert(vararg user: User)

    @Delete
    fun delete(user: User)

}