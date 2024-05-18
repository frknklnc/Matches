package com.example.matches.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.matches.data.local.model.FavouriteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouriteDao {
    @Insert
    suspend fun insertMatch(vararg entity: FavouriteEntity)

    @Query("SELECT * FROM favourites")
    fun getMatches(): Flow<List<FavouriteEntity>>

    @Query("DELETE FROM favourites WHERE matchId = :id")
    suspend fun deleteMatch(id: Int)
}