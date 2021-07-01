package com.example.compose_study.ui.screen.animation

import com.example.compose_study.ui.screen.animation.samples.DotLoading
import com.example.compose_study.ui.screen.replaceable.ComposableReplaceableView
import com.example.compose_study.ui.screen.replaceable.ReplaceableViewCategory

val AnimationSamples = ReplaceableViewCategory(
    "AnimationSamples",
    listOf(
        ComposableReplaceableView("DotLoadingSample") { DotLoading() }
    )
)
