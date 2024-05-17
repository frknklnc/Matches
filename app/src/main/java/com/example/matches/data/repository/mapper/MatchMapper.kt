package com.example.matches.data.repository.mapper

import com.example.matches.data.local.model.FavouriteEntity
import com.example.matches.data.remote.model.MatchesDto
import com.example.matches.domain.model.MatchModel

class MatchMapper {

    fun map(
        matchDto: MatchesDto.MatchDto,
        favouriteList: List<FavouriteEntity>
    ): MatchModel {
        val isFavourite = favouriteList.any { it.matchId == matchDto.matchId }
        return MatchModel(
            matchId = matchDto.matchId,
            homeTeamName = matchDto.homeTeamDto.name,
            awayTeamName = matchDto.awayTeamDto.name,
            matchStatus = matchDto.scoreInformationDto.matchStatus,
            homeTeamHalfScore = matchDto.scoreInformationDto.homeTeamScoreDto?.halfScore,
            homeTeamScore = matchDto.scoreInformationDto.homeTeamScoreDto?.score,
            awayTeamHalfScore = matchDto.scoreInformationDto.awayTeamScoreDto?.halfScore,
            awayTeamScore = matchDto.scoreInformationDto.awayTeamScoreDto?.score,
            leagueName = matchDto.leagueInformationDto.name,
            leagueFlag = matchDto.leagueInformationDto.flag,
            isFavourite = isFavourite
        )
    }
}