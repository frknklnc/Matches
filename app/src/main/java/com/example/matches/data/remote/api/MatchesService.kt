package com.example.matches.data.remote.api

import com.example.matches.data.remote.model.MatchesDto
import retrofit2.http.GET

interface MatchesService {
    @GET("statistics/sport/SOCCER/matches")
    suspend fun getMatches(): MatchesDto
}