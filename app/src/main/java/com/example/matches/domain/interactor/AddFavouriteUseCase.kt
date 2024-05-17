package com.example.matches.domain.interactor

import com.example.matches.base.BaseUseCase
import com.example.matches.domain.repository.MatchesRepository
import javax.inject.Inject

class AddFavouriteUseCase @Inject constructor(private val matchesRepository: MatchesRepository) :
    BaseUseCase<AddFavouriteUseCase.Params, Unit>() {

    override suspend fun build(params: Params) {
        matchesRepository.addFavourite(params.matchId)
    }

    data class Params(
        val matchId: Int
    )
}