package com.example.matches.data.model.locale

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [FavouritesEntities::class], version = 1)
abstract class FavouritesDatabase : RoomDatabase() {
    abstract fun favouritesDao(): FavouritesDao
}