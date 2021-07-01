package com.example.compose_study.ui.common

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

/**
 * TODO: remove after b/154329050 is fixed
 * Inline classes don't play well with reflection, so we want boxed classes for our
 * call to [lightColors].
 */
internal fun reflectLightColors(
    primary: Long = 0xFF6200EE,
    primaryVariant: Long = 0xFF3700B3,
    secondary: Long = 0xFF03DAC6,
    secondaryVariant: Long = 0xFF018786,
    background: Long = 0xFFFFFFFF,
    surface: Long = 0xFFFFFFFF,
    error: Long = 0xFFB00020,
    onPrimary: Long = 0xFFFFFFFF,
    onSecondary: Long = 0xFF000000,
    onBackground: Long = 0xFF000000,
    onSurface: Long = 0xFF000000,
    onError: Long = 0xFFFFFFFF
) = lightColors(
    primary = Color(primary),
    primaryVariant = Color(primaryVariant),
    secondary = Color(secondary),
    secondaryVariant = Color(secondaryVariant),
    background = Color(background),
    surface = Color(surface),
    error = Color(error),
    onPrimary = Color(onPrimary),
    onSecondary = Color(onSecondary),
    onBackground = Color(onBackground),
    onSurface = Color(onSurface),
    onError = Color(onError)
)

/**
 * TODO: remove after b/154329050 is fixed
 * Inline classes don't play well with reflection, so we want boxed classes for our
 * call to [darkColors].
 */
internal fun reflectDarkColors(
    primary: Long = 0xFFBB86FC,
    primaryVariant: Long = 0xFF3700B3,
    secondary: Long = 0xFF03DAC6,
    background: Long = 0xFF121212,
    surface: Long = 0xFF121212,
    error: Long = 0xFFCF6679,
    onPrimary: Long = 0xFF000000,
    onSecondary: Long = 0xFF000000,
    onBackground: Long = 0xFFFFFFFF,
    onSurface: Long = 0xFFFFFFFF,
    onError: Long = 0xFF000000
) = darkColors(
    primary = Color(primary),
    primaryVariant = Color(primaryVariant),
    secondary = Color(secondary),
    background = Color(background),
    surface = Color(surface),
    error = Color(error),
    onPrimary = Color(onPrimary),
    onSecondary = Color(onSecondary),
    onBackground = Color(onBackground),
    onSurface = Color(onSurface),
    onError = Color(onError)
)