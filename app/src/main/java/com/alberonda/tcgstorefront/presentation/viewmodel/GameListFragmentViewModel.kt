package com.alberonda.tcgstorefront.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alberonda.tcgstorefront.domain.GameListUseCases
import com.alberonda.tcgstorefront.model.data.Game
import com.alberonda.tcgstorefront.model.network.StorefrontApi
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameListFragmentViewModel : ViewModel() {

    /**
     * The list with all the games in the app
     */
    private val _games = MutableLiveData<List<Game>>(emptyList())
    val games: LiveData<List<Game>>
        get() = _games

    /**
     * Show a loading spinner if true
     */
    private val _spinner = MutableLiveData<Boolean>(false)
    val spinner: LiveData<Boolean>
        get() = _spinner

    /**
     * Request a snackbar to display a string.
     */
    private val _snackbar = MutableLiveData<String?>()
    val snackbar: LiveData<String?>
        get() = _snackbar

    init {
        loadGames()
    }

    private fun loadGames() {
        viewModelScope.launch {
            try {
                launchDataLoad{
                    _games.value = StorefrontApi.retrofitService.getGames().games
                }
            } catch (e: Exception) {
                _games.value = listOf(Game(-1,e.message!!))
            }
        }
    }

    private fun launchDataLoad(block: suspend () -> Unit): Job {
        return viewModelScope.launch {
            try {
                _spinner.value = true
                block()
            } catch (error: Throwable) {
                _snackbar.value = error.message
            } finally {
                _spinner.value = false
            }
        }
    }

    /**
     * Called immediately after the UI shows the snackbar.
     */
    fun onSnackbarShown() {
        _snackbar.value = null
    }
}