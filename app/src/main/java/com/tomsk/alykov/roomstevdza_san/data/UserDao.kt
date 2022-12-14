package com.tomsk.alykov.roomstevdza_san.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

//интерфейс который содержит методы для доступа к данным
@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addUser(user: User)

    @Query("select * from user_table order by id asc")
    fun readAllData(): LiveData<List<User>>

}