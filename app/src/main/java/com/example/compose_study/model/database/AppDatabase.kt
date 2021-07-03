package com.example.compose_study.model.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.compose_study.model.dao.UserDao
import com.example.compose_study.model.entity.User

@Database(entities = arrayOf(User::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}