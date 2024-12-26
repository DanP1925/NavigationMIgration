package com.danp1925.navigationmigration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _toolbarTitle = MutableStateFlow("")
    val toolbarTitle: StateFlow<String> = _toolbarTitle

    private val _events = MutableSharedFlow<MainEvents>()
    val events: SharedFlow<MainEvents> = _events.asSharedFlow()

    fun updateToolbar(newValue: String) {
        _toolbarTitle.value = newValue
    }

    fun navigateToSecondScreen() {
        viewModelScope.launch {
            _events.emit(MainEvents.NavigateToSecondScreen("String from First Screen"))
        }
    }

    fun navigateFromFirstToThirdScreen() {
        viewModelScope.launch {
            _events.emit(MainEvents.NavigateFromFirstToThirdScreen)
        }
    }

    fun navigateFromSecondToThirdScreen() {
        viewModelScope.launch {
            _events.emit(MainEvents.NavigateFromSecondToThirdScreen)
        }
    }
}

sealed class MainEvents {
    data class NavigateToSecondScreen(val stringArgument: String) : MainEvents()
    data object NavigateFromFirstToThirdScreen : MainEvents()
    data object NavigateFromSecondToThirdScreen : MainEvents()
}
