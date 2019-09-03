package com.tomlettuces.home.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.tomlettuces.home.db.UserDao
import com.tomlettuces.home.db.UserDataBase
import com.tomlettuces.home.db.entity.User

class RoomViewModel(app: Application) : AndroidViewModel(app) {

    private val dao: UserDao by lazy { UserDataBase.getInstance(app).userDao() }
    var id: Int = 0
    lateinit var userData: List<User>
    var userLiveData = MutableLiveData<String>()

    init {
        queryBtnTransaction()
        if (userData.isNotEmpty()) {
            id = userData.size
        }
    }

    fun insertDao(user: User) {
        dao.insert(user)
    }

    fun deleteDao(user: User) {
        dao.delete(user)
    }

    fun showData(): String {
        var dataChar = ""
        userData.forEach {
            dataChar += it.name + it.age + ","
        }
        return dataChar
    }

    fun addBtnTransaction() {
        val user = createUser(id)
        insertDao(user)
        id++
        Log.i("Room_UserDao", "新增数据 id = ${user.id}, name = ${user.name}, age = ${user.age}")
    }

    fun deleteBtnTransaction() {
        if (id > 0) {
            id--
            val user = createUser(id)
            deleteDao(user)
            Log.i("Room_UserDao", "删除数据 id = ${user.id}, name = ${user.name}, age = ${user.age}")
        }
    }

    fun queryBtnTransaction() {
        userData = dao.loadAll()
        userLiveData.value = showData()
    }

    fun createUser(id: Int): User {
        val tempData = User(id)
        tempData.name = "Tom"
        tempData.age = (5..40).random()
        return tempData
    }

}