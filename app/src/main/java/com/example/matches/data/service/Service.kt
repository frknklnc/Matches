package com.example.matches.data.service

import com.example.matches.data.model.MatchesResponse
import retrofit2.http.GET

interface Service {
    @GET("statistics/sport/SOCCER/matches")
    suspend fun getMatches(): MatchesResponse
}