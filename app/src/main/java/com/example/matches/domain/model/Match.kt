package com.example.matches.domain.model

import java.io.Serializable
data class Match(
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
) : Serializable