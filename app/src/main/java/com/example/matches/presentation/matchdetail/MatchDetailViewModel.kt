package com.example.matches.presentation.matchdetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matches.domain.interactor.AddFavouriteUseCase
import com.example.matches.domain.interactor.DeleteFavouriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MatchDetailViewModel @Inject constructor(
    private val addFavouriteUseCase: AddFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase
) : ViewModel() {

    private val _favouriteState = MutableStateFlow(false)
    val favouriteState: StateFlow<Boolean> = _favouriteState

    fun addFavourite(matchId: Int) {
        viewModelScope.launch {
            addFavouriteUseCase.execute(AddFavouriteUseCase.Params(matchId))
            _favouriteState.value = true
        }
    }

    fun removeFavourite(matchId: Int) {
        viewModelScope.launch {
            deleteFavouriteUseCase.execute(DeleteFavouriteUseCase.Params(matchId))
            _favouriteState.value = false
        }
    }

    fun initializeFavouriteState(isFavourite: Boolean){
        _favouriteState.value = isFavourite
    }
}