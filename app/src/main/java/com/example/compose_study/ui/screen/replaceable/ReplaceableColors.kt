package com.example.compose_study.ui.screen.replaceable

import android.content.SharedPreferences
import androidx.compose.runtime.Stable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.material.Colors
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors

/**
 * Wrapper class that contains a light and dark [Colors], to allow saving and
 * restoring the entire light / dark theme to and from [SharedPreferences].
 */
@Stable
class ReplaceableColors {
    var light: Colors by mutableStateOf(lightColors())
    var dark: Colors by mutableStateOf(darkColors())


}
