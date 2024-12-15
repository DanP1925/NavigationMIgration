package com.danp1925.navigationmigration

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MainViewModel : ViewModel() {

    private val _toolbarTitle = MutableStateFlow("")
    val toolbarTitle: StateFlow<String> = _toolbarTitle

    fun updateToolbar(newValue: String) {
        _toolbarTitle.value = newValue
    }
}