package com.example.matches.data.model.locale

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("favourites")
data class FavouritesEntities(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("matchId")
    val mathcId: Int
)