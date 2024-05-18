package com.example.matches.data.remote.datasource

import com.example.matches.data.remote.api.MatchesService
import com.example.matches.data.remote.model.MatchesDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MatchesRemoteDataSource @Inject constructor(private val matchesService: MatchesService) {

    fun getMatches(): Flow<MatchesDto>{
        return flow {
            emit(matchesService.getMatches())
        }
    }
}