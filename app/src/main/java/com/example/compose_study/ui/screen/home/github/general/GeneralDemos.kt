package com.example.compose_study.ui.screen.home.github.general

import com.example.compose_study.ui.screen.home.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.home.replaceable.ReplaceableViewCategory

val GeneralSamples = ReplaceableViewCategory(
    "General",
    listOf(
        ComposableReplaceableView("LifecycleSample") { LifecycleSample() },
        ComposableReplaceableView("PaddingSample") { PaddingSample() },
        )
)
