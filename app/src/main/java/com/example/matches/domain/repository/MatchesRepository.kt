package com.example.matches.domain.repository

import com.example.matches.domain.model.MatchModel
import kotlinx.coroutines.flow.Flow


interface MatchesRepository {

    fun getMatches(): Flow<Map<String, List<MatchModel>>>

    suspend fun addFavourite(matchId: Int)

    suspend fun deleteFavourite(matchId: Int)
}