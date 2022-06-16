package com.alberonda.tcgstorefront.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApi
import kotlinx.coroutines.launch

class MainFragmentViewModel : ViewModel() {

    /**
     * The list with all the games in the app
     */
    private val _games = MutableLiveData<List<Game>>(emptyList())
    val games: LiveData<List<Game>>
        get() = _games

    init {
        loadGames()
    }

    private fun loadGames() {
        viewModelScope.launch {
            try {
                _games.value = StorefrontApi.retrofitService.getGames().games

            } catch (e: Exception) {
                _games.value = listOf(Game(-1,e.message!!))
            }
        }
    }
}