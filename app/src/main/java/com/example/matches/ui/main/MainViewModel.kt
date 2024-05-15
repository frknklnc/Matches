package com.example.matches.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.matches.data.domain.MatchesUseCase
import com.example.matches.data.model.remote.MatchModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val matchesUseCase: MatchesUseCase) : ViewModel() {

    private val _matches = MutableLiveData<Map<String, List<MatchModel>>>()
    val matchesLiveData: LiveData<Map<String, List<MatchModel>>> = _matches

    init {
        getMatches()
    }

    fun getMatches() {
        matchesUseCase.execute(Unit)
            .onEach {
                _matches.value = it
            }
            .catch {
            //TODO error handling
            }
            .launchIn(viewModelScope)
    }
}