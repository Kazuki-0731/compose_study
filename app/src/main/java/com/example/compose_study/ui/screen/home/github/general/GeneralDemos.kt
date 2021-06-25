package com.example.compose_study.ui.screen.home.github.general

import com.example.compose_study.ui.screen.home.demo.ComposableDemo
import com.example.compose_study.ui.screen.home.demo.DemoCategory

val GeneralDemos = DemoCategory(
    "General",
    listOf(
        ComposableDemo("LifecycleDemo") { LifecycleDemo() },
        ComposableDemo("PaddingDemo") { PaddingDemo() },
        )
)
