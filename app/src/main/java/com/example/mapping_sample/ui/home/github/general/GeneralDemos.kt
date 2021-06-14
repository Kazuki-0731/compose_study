package com.example.mapping_sample.ui.home.github.general

import com.example.mapping_sample.ui.home.demo.ComposableDemo
import com.example.mapping_sample.ui.home.demo.DemoCategory

val GeneralDemos = DemoCategory(
    "General",
    listOf(
        ComposableDemo("LifecycleDemo") { LifecycleDemo() },
        ComposableDemo("PaddingDemo") { PaddingDemo() },
        )
)
