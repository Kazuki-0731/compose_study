package com.example.compose_study.ui.screen.home.jetpack_compose.general

import com.example.compose_study.ui.common.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.common.replaceable.ReplaceableViewCategory

val GeneralSamples = ReplaceableViewCategory(
    "General",
    listOf(
        ComposableReplaceableView("LifecycleSample") { LifecycleSample() },
        ComposableReplaceableView("PaddingSample") { PaddingSample() },
        )
)
