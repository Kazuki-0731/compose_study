package com.example.compose_study.ui.screen.home.github.androidview

import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory

val AndroidViewDemo = DemoCategory(
    "AndroidViewDemo",
    listOf(
        ComposableDemo("AndroidViewDemo") { EmbeddedAndroidViewDemo() }
    )
)
