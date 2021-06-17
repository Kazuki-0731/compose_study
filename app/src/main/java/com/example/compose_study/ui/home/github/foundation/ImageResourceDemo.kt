package com.example.compose_study.ui.home.github.foundation

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.compose_study.R


@Composable
fun ImageResourceDemo() {
    val image: Painter = painterResource(id = R.drawable.composelogo)
    Image(painter = image,contentDescription = "")
}

