package com.example.compose_study.ui.screen.home.github.cookbook.textfieldchange


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Preview
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HandleTextFieldChanges() {
    var textState by remember { mutableStateOf(TextFieldValue()) }

    TextField(value = textState, onValueChange = {
        textState = it
    })
}