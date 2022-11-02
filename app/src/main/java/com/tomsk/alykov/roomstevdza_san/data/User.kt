package com.tomsk.alykov.roomstevdza_san.data

import androidx.room.Entity
import androidx.room.PrimaryKey

//представляет собой таблицу с именем user_table
@Entity(tableName = "user_table")
class User (
    @PrimaryKey(autoGenerate = true) val id: Int,
    val firstName: String,
    val secondName: String,
    val age: Int
) {
}