package com.example.compose_study.ui.screen.home.jetpack_compose.layout


import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable




@Composable
fun ColumnDemo() {
    MaterialTheme {
        ColumnSample()
    }
}

@Composable
fun ColumnSample() {
    Column {
        Text(text = " Hello World!")
        Text(text = " Hello World!2")
    }
}