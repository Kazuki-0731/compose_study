package com.example.compose_study.ui.home.github.general

import com.example.compose_study.ui.home.demo.ComposableDemo
import com.example.compose_study.ui.home.demo.DemoCategory

val GeneralDemos = DemoCategory(
    "General",
    listOf(
        ComposableDemo("LifecycleDemo") { LifecycleDemo() },
        ComposableDemo("PaddingDemo") { PaddingDemo() },
        )
)
