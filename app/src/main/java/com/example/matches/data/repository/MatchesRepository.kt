package com.example.matches.data.repository

import com.example.matches.base.data.repository.BaseRepository
import com.example.matches.data.model.locale.FavouritesDao
import com.example.matches.data.model.locale.FavouritesEntities
import com.example.matches.data.model.remote.MatchModel
import com.example.matches.data.service.Service
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchesRepository @Inject constructor(
    private val remoteService: Service,
    private val localeService: FavouritesDao
) : BaseRepository() {

    fun getMatches(): Flow<Map<String, List<MatchModel>>> {
        return fetch {
            val favourites = localeService.getMatches()
            val matches = remoteService.getMatches().data
                .filter { it.sc.matchStatus == "MS" }
                .sortedByDescending { it.matchDate }
                .map { matchData ->
                    val isFavourite = favourites.any { it.mathcId == matchData.matchId }
                    MatchModel(
                        matchId = matchData.matchId,
                        homeTeamName = matchData.homeTeam.name,
                        awayTeamName = matchData.awayTeam.name,
                        matchStatus = matchData.sc.matchStatus,
                        homeTeamHalfScore = matchData.sc.homeTeam?.halfScore,
                        homeTeamScore = matchData.sc.homeTeam?.score,
                        awayTeamHalfScore = matchData.sc.awayTeam?.halfScore,
                        awayTeamScore = matchData.sc.awayTeam?.score,
                        leagueName = matchData.leagueInformation.name,
                        leagueFlag = matchData.leagueInformation.flag,
                        isFavourite = isFavourite
                    )
                }

            val groupedMatches = matches.groupBy { it.leagueName }

            groupedMatches
        }
    }

    fun addFavourites(id: Int): Flow<Unit> {
        return fetch {
            val entity = FavouritesEntities(mathcId = id)
            localeService.insertMatch(entity)
        }
    }

    fun deleteFavourites(id: Int): Flow<Unit> {
        return fetch {
            localeService.deleteMatch(id)
        }
    }
}