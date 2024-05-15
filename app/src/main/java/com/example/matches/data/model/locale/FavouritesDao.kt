package com.example.matches.data.model.locale

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavouritesDao {
    @Insert
    suspend fun insertMatch(vararg entity: FavouritesEntities)

    @Query("SELECT * FROM favourites")
    suspend fun getMatches(): List<FavouritesEntities>

    @Query("DELETE FROM favourites WHERE matchId = :id")
    suspend fun deleteMatch(id: Int)
}