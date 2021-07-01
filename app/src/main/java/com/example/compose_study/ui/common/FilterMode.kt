package com.example.compose_study.ui.common

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class FilterMode(backDispatcher: OnBackPressedDispatcher, initialValue: Boolean = false) {

    private var _isFiltering by mutableStateOf(initialValue)

    private val onBackPressed = object : OnBackPressedCallback(false) {
        override fun handleOnBackPressed() {
            isFiltering = false
        }
    }.apply {
        isEnabled = initialValue
        backDispatcher.addCallback(this)
    }

    var isFiltering
        get() = _isFiltering
        set(value) {
            _isFiltering = value
            onBackPressed.isEnabled = value
        }

    companion object {
        fun Saver(backDispatcher: OnBackPressedDispatcher) =
            androidx.compose.runtime.saveable.Saver<FilterMode, Boolean>(
                save = { it.isFiltering },
                restore = { FilterMode(backDispatcher, it) }
            )
    }
}
