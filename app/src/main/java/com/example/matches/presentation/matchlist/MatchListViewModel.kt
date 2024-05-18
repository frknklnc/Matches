package com.example.matches.presentation.matchlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matches.domain.interactor.AddFavouriteUseCase
import com.example.matches.domain.interactor.DeleteFavouriteUseCase
import com.example.matches.domain.interactor.GetMatchesFlowUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchListViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesFlowUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase
) : ViewModel() {

    val matchesData = getMatchesUseCase.execute(Unit)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = emptyMap()
        )

    fun addFavourite(matchId: Int) {
        viewModelScope.launch {
            addFavouriteUseCase.execute(AddFavouriteUseCase.Params(matchId))
        }
    }

    fun removeFavourite(matchId: Int) {
        viewModelScope.launch {
            deleteFavouriteUseCase.execute(DeleteFavouriteUseCase.Params(matchId))
        }
    }
}