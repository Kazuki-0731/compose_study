package com.example.compose_study.ui.screen.home.github.other

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.example.compose_study.R


@Composable
fun AndroidContextComposeDemo() {
    MaterialTheme {
        val context = LocalContext.current
        Text(text = "Read this string from Context: "+context.getString(R.string.app_name))
    }
}
