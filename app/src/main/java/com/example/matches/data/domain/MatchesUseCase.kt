package com.example.matches.data.domain

import com.example.matches.base.data.usecase.BaseUseCase
import com.example.matches.data.model.remote.MatchModel
import com.example.matches.data.repository.MatchesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MatchesUseCase @Inject constructor(private val repository: MatchesRepository) :
    BaseUseCase<Unit, Map<String, List<MatchModel>>>() {
    override fun build(params: Unit): Flow<Map<String, List<MatchModel>>> {
        return repository.getMatches()
    }
}