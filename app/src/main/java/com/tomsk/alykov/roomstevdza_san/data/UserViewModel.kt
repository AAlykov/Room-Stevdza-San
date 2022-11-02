package com.tomsk.alykov.roomstevdza_san.data

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

//роль - предоставлять данные для UI и держать изменения конфигурации. Работает как коммуникатор между Репозиторием и UI
class UserViewModel(application: Application): AndroidViewModel(application) {
    private val readAllData: LiveData<List<User>>
    private val repository: UserRepository


    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        readAllData = repository.readAllData
    }

    fun addUser(user: User) {
        viewModelScope.launch ( Dispatchers.IO ) {
            repository.addUser(user)
        }
    }

}