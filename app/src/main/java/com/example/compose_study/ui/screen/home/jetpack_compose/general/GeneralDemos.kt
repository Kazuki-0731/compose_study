package com.example.compose_study.ui.screen.home.jetpack_compose.general

import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory

val GeneralSamples = ReplaceableViewCategory(
    "General",
    listOf(
        ComposableReplaceableView("LifecycleSample") { LifecycleSample() },
        ComposableReplaceableView("PaddingSample") { PaddingSample() },
        )
)
