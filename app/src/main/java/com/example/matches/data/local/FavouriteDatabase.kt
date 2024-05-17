package com.example.matches.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.matches.data.local.model.FavouriteEntity

@Database(entities = [FavouriteEntity::class], version = 1)
abstract class FavouriteDatabase : RoomDatabase() {
    abstract fun favouritesDao(): FavouriteDao
}