package com.example.compose_study.ui.home.github.animation.crossfade

import android.content.res.Configuration
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


enum class AnimeColors(val color: Color) {
    Red(Color.Red), Green(Color.Green), Blue(Color.Blue)
}

@Preview(showBackground = true)
@Composable
fun crossfadeColor() {
    var currentColor by remember { mutableStateOf(AnimeColors.Red) }
    Column {
        Crossfade(targetState = currentColor, animationSpec = tween(3000)) { selectedColor ->
            Box(modifier = Modifier.fillMaxSize().background(selectedColor.color))
        }
        Row {
            AnimeColors.values().forEach { color ->
                Button(
                    onClick = { currentColor = color },
                    Modifier
                        .weight(1f, true)
                        .height(48.dp)
                        .background(color.color),
                    colors = ButtonDefaults.buttonColors(backgroundColor = color.color),
                ) {
                    Text(color.name)
                }
            }
        }
    }
}

