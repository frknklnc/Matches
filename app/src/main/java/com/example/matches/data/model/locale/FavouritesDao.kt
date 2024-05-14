package com.example.matches.data.model.locale

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouritesDao {
     @Insert
     suspend fun insertMatch(vararg entity: FavouritesEntities)

     @Query("SELECT * FROM favourites WHERE matchId = :id")
     suspend fun getMatches(id: Int): List<FavouritesEntities>

     @Delete
     suspend fun deleteMatch(entity: FavouritesEntities)
}