package com.tomsk.alykov.roomstevdza_san.data

import androidx.lifecycle.LiveData

//класс который абстрагирует доступ к нескольким источникам данных
class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User) {
        userDao.addUser(user)
    }

}