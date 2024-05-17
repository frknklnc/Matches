package com.example.matches.domain.interactor

import com.example.matches.base.BaseUseCase
import com.example.matches.domain.repository.MatchesRepository
import javax.inject.Inject

class DeleteFavouriteUseCase @Inject constructor(private val matchesRepository: MatchesRepository) :
    BaseUseCase<DeleteFavouriteUseCase.Params, Unit>() {

    override suspend fun build(params: Params) {
        matchesRepository.deleteFavourite(params.matchId)
    }

    data class Params(
        val matchId: Int
    )
}