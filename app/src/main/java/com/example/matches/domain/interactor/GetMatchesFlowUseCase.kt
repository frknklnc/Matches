package com.example.matches.domain.interactor

import com.example.matches.base.BaseFlowUseCase
import com.example.matches.domain.model.MatchModel
import com.example.matches.domain.repository.MatchesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMatchesFlowUseCase @Inject constructor(private val matchesRepository: MatchesRepository) :
    BaseFlowUseCase<Unit, Map<String, List<MatchModel>>>() {
    override fun build(params: Unit): Flow<Map<String, List<MatchModel>>> {
        return matchesRepository.getMatches()
    }
}