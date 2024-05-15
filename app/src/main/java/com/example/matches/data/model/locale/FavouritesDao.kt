package com.example.matches.data.model.locale

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouritesDao {
     @Insert
     suspend fun insertMatch(vararg entity: FavouritesEntities)

     @Query("SELECT * FROM favourites")
     suspend fun getMatches(): List<FavouritesEntities>

     @Delete
     suspend fun deleteMatch(entity: FavouritesEntities)
}