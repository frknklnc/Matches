package com.example.matches.domain.repository

import com.example.matches.domain.model.Match
import kotlinx.coroutines.flow.Flow


interface MatchesRepository {

    fun getMatches(): Flow<Map<String, List<Match>>>

    suspend fun addFavourite(matchId: Int)

    suspend fun deleteFavourite(matchId: Int)
}