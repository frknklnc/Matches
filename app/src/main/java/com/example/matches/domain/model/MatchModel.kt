package com.example.matches.domain.model

data class MatchModel(
    val matchId: Int,
    val homeTeamName: String,
    val awayTeamName: String,
    val matchStatus: String,
    val homeTeamHalfScore: Int?,
    val homeTeamScore: Int?,
    val awayTeamHalfScore: Int?,
    val awayTeamScore: Int?,
    val leagueName: String,
    val leagueFlag: String,
    val isFavourite: Boolean
)