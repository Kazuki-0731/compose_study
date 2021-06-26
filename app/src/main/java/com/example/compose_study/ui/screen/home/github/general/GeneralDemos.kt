package com.example.compose_study.ui.screen.home.github.general

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory

val GeneralDemos = ReplaceableViewCategory(
    "General",
    listOf(
        ComposableReplaceableView("LifecycleDemo") { LifecycleDemo() },
        ComposableReplaceableView("PaddingDemo") { PaddingDemo() },
        )
)
