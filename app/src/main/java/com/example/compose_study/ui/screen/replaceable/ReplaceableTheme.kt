package com.example.compose_study.ui.screen.replaceable

import android.view.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb

@Composable
fun ReplaceableTheme(
    replaceableColors: ReplaceableColors,
    window: Window,
    content: @Composable () -> Unit
) {
    MaterialTheme() {
        val statusBarColor = with(MaterialTheme.colors) {
            (if (isLight) primaryVariant else Color.Black).toArgb()
        }
        SideEffect {
            window.statusBarColor = statusBarColor
        }
        content()
    }
}
