package com.example.compose_study.ui.home.github.androidview

import com.example.compose_study.ui.home.demo.ComposableDemo
import com.example.compose_study.ui.home.demo.DemoCategory

val AndroidViewDemo = DemoCategory(
    "AndroidViewDemo",
    listOf(
        ComposableDemo("AndroidViewDemo") { EmbeddedAndroidViewDemo() }
    )
)
