package com.example.matches.data.repository

import com.example.matches.base.BaseRepository
import com.example.matches.data.local.FavouriteDao
import com.example.matches.data.local.model.FavouriteEntity
import com.example.matches.data.remote.api.MatchesService
import com.example.matches.data.repository.mapper.MatchMapper
import com.example.matches.domain.model.Match
import com.example.matches.domain.repository.MatchesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val remoteMatchesService: MatchesService,
    private val localeService: FavouriteDao
) : BaseRepository(), MatchesRepository {

    private val matchMapper: MatchMapper = MatchMapper()
    override fun getMatches(): Flow<Map<String, List<Match>>> {
        return fetch {
            val favourites = localeService.getMatches()
            val matches = remoteMatchesService.getMatches().data
                .filter { it.scoreInformationDto.matchStatus == "MS" }
                .sortedByDescending { it.matchDate }
                .map { matchDto ->
                    matchMapper.map(matchDto, favourites)
                }

            val groupedMatches = matches.groupBy { it.leagueName }

            groupedMatches
        }
    }

    override suspend fun addFavourite(matchId: Int) {
        val entity = FavouriteEntity(matchId = matchId)
        localeService.insertMatch(entity)
    }

    override suspend fun deleteFavourite(matchId: Int) {
        localeService.deleteMatch(matchId)
    }
}