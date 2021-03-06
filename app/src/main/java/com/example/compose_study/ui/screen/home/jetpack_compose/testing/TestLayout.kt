package com.example.compose_study.ui.screen.home.jetpack_compose.testing

import androidx.compose.foundation.clickable
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun MainLayout() {
    val state = remember { mutableStateOf("Welcome")}
    Text(state.value,modifier = Modifier.clickable { state.value="Bye" })
}