package com.example.matches.data.repository

import com.example.matches.data.local.FavouriteDao
import com.example.matches.data.local.model.FavouriteEntity
import com.example.matches.data.remote.datasource.MatchesRemoteDataSource
import com.example.matches.data.repository.mapper.MatchMapper
import com.example.matches.domain.model.Match
import com.example.matches.domain.repository.MatchesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

class MatchesRepositoryImpl @Inject constructor(
    private val favouriteDao: FavouriteDao,
    private val matchesRemoteDataSource: MatchesRemoteDataSource,
) : MatchesRepository {

    private val matchMapper: MatchMapper = MatchMapper()

    override val matchesStream: Flow<Map<String, List<Match>>> = combine(
        favouriteDao.getMatches(),
        matchesRemoteDataSource.getMatches()
    ) { favourites, matchesDto ->

        val matches = matchesDto.data
            .filter { it.scoreInformationDto.matchStatus == "MS" }
            .sortedByDescending { it.matchDate }
            .map { matchDto ->
                matchMapper.map(matchDto, favourites)
            }

        val groupedMatches = matches.groupBy { it.leagueName }

        groupedMatches
    }

    override suspend fun addFavourite(matchId: Int) {
        val entity = FavouriteEntity(matchId = matchId)
        favouriteDao.insertMatch(entity)
    }

    override suspend fun deleteFavourite(matchId: Int) {
        favouriteDao.deleteMatch(matchId)
    }
}