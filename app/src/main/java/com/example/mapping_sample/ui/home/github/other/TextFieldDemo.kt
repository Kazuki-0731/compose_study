package com.example.mapping_sample.ui.home.github.other

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.input.TextFieldValue


@Composable
fun TextFieldDemo() {
    Column {
        var state =  TextFieldValue("")
        BasicTextField(
            value = state,
            onValueChange = {value-> state= value  }
        )
        Text("The textfield has this text: "+state)
    }
}