package com.example.matches.presantation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matches.domain.interactor.AddFavouriteUseCase
import com.example.matches.domain.interactor.DeleteFavouriteUseCase
import com.example.matches.domain.interactor.GetMatchesFlowUseCase
import com.example.matches.domain.model.MatchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getMatchesUseCase: GetMatchesFlowUseCase,
    private val addFavouriteUseCase: AddFavouriteUseCase,
    private val deleteFavouriteUseCase: DeleteFavouriteUseCase
) : ViewModel() {

    private val _matches = MutableLiveData<Map<String, List<MatchModel>>>()
    val matchesLiveData: LiveData<Map<String, List<MatchModel>>> = _matches

    init {
        getMatches()
    }

    fun getMatches() {
        getMatchesUseCase.execute(Unit)
            .onEach {
                _matches.value = it
            }
            .catch {
                //TODO error handling
            }
            .launchIn(viewModelScope)
    }


    fun addFavourite(matchId: Int) {
        viewModelScope.launch {
            addFavouriteUseCase.execute(AddFavouriteUseCase.Params(matchId))
            getMatches()
        }
    }

    fun removeFavourite(matchId: Int) {
        viewModelScope.launch {
            deleteFavouriteUseCase.execute(DeleteFavouriteUseCase.Params(matchId))
            getMatches()
        }
    }
}